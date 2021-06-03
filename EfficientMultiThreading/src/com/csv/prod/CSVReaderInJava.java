package com.csv.prod;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple Java program to read CSV file in Java. In this program we will read
 * list of books stored in CSV file as comma separated values.
 * 
 * @author WINDOWS 8
 *
 */
public class CSVReaderInJava {

    public static void main(String... args) throws IOException {
        List<PICVData> picvData = readBooksFromCSV("Serial_Ban_Aggr.csv","PICV_FEED.csv");
        String csvFile = "developer.csv";
        FileWriter writer = new FileWriter(csvFile);
        CSVUtils.writeLine(writer, Arrays.asList("customer_id" , "customer_type" , "billing_account_reference" , "product_order_id" , "order_date" , "order_completed_date" , "product_instance_id" , "Serial_number" , "type"));
    		
            for (PICVData d : picvData) {

                List<String> list = new ArrayList<>();
                list.add(d.getCustomer_id());
                list.add(d.getCustomer_type());
                list.add(d.getBilling_account_reference());
                list.add(d.getProduct_order_id());
                list.add(d.getOrder_date());
                list.add(d.getOrder_completed_date());
                list.add(d.getProduct_instance_id());
                list.add(d.getSerial_number());
                list.add(d.getType());
 
                
                CSVUtils.writeLine(writer, list);

    			//try custom separator and quote. 
    			//CSVUtils.writeLine(writer, list, '|', '\"');
            }

            writer.flush();
            writer.close();

        
    }

    private static List<PICVData> readBooksFromCSV(String firstFile,String secondFile) {
    	Map<String,List<SerialBanUsed>> map=new HashMap<String,List<SerialBanUsed>>();
        Path pathToFile = Paths.get(firstFile);

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                String ban= attributes[0];
                String serial= attributes[1];
                String type= "notUsed";
               if(map.containsKey(ban)) {
            	   map.get(ban).add(new SerialBanUsed(ban, serial, type));
            	   
               }else {
            	   List<SerialBanUsed> list= new ArrayList<SerialBanUsed>();
            	   list.add(new SerialBanUsed(ban, serial, type));
            	   map.put(ban, list);
               }
               
                 
             //   Book book = createBook(attributes);
                
                
                

                // adding book into ArrayList
                

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        List<PICVData> picvDatas = new ArrayList<>(); 
        Path pathToFileSecond = Paths.get(secondFile);
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFileSecond,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                                               
                PICVData picvData = createBook(attributes,map);
                
                
                if(picvData.getSerial_number()!=null && !"#N/A".equalsIgnoreCase(picvData.getSerial_number())) {
                	picvDatas.add(picvData);	
                }

                // adding book into ArrayList
                

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return picvDatas;
    }

	private static PICVData createBook(String[] metadata,Map<String,List<SerialBanUsed> > map) {
		
		Map<String,String> mapOfValues=new HashMap<>();
		String customer_id = metadata[0];
		String customer_type = metadata[1];
		String billing_account_reference = metadata[2];
		String product_order_id = metadata[3];
		String order_date = metadata[4];
		String order_completed_date = metadata[5];
		String product_instance_id = metadata[6];
		String Serial_number =null;
		String type = "Provide";
		
		
		//String finalString = "";
		if ("#N/A".equalsIgnoreCase(metadata[7])) {
			if(map.containsKey(billing_account_reference)) {
			List<SerialBanUsed> serialBanUseds=map.get(billing_account_reference);
			if(serialBanUseds!=null && !serialBanUseds.isEmpty()) {
			for(SerialBanUsed serialBanUsed:serialBanUseds) {
				if(serialBanUsed.getType().equalsIgnoreCase("notUsed")) {							
				Serial_number=serialBanUsed.getSerial_Number();				
				serialBanUsed.setType("Used");
				}
			}}else {
				Serial_number="#N/A";
			}
			}} else {
				Serial_number=metadata[7];
				if(map.containsKey(billing_account_reference)) {
					List<SerialBanUsed> serialBanUseds=map.get(billing_account_reference);
					if(serialBanUseds!=null && !serialBanUseds.isEmpty()) {
						for(SerialBanUsed serialBanUsed:serialBanUseds) {
							if(serialBanUsed.getSerial_Number().equalsIgnoreCase(Serial_number)) {							
						//	Serial_number=serialBanUsed.getSerial_Number();
							serialBanUsed.setType("Used");
							}
						}
						
					}}
			
			
		}
	//	mapOfValues.put(key, value)

		// create and return book of this metadata
		return new PICVData
				(customer_id,customer_type,billing_account_reference,product_order_id,order_date,order_completed_date,product_instance_id,Serial_number,type);
	}
	
	
	/*private static Book createPicv(String[] metadata) {
		String name = metadata[0];
		String price = metadata[1];
		String finalString = "";
		if ("#N/A".equalsIgnoreCase(name) && "#N/A".equalsIgnoreCase(price)) {
			finalString = "#N/A";
		} else if ("#N/A".equalsIgnoreCase(name) && !"#N/A".equalsIgnoreCase(price)) {
			finalString = price;
		} else {
			finalString = name;
		}

		// create and return book of this metadata
		return new Book(name, price, finalString);
	}
*/


}

class Book {
    private String Serial_number;
    private String Serial_number_3rd;
    private String final_serial_number;

    public Book(String Serial_number, String Serial_number_3rd, String final_serial_number) {
    	
    	this.Serial_number=Serial_number;
       this.Serial_number_3rd=Serial_number_3rd;
       this.final_serial_number=final_serial_number;
    }
    
    
    

	@Override
	public String toString() {
		return "Book [Serial_number=" + Serial_number + ", Serial_number_3rd=" + Serial_number_3rd
				+ ", final_serial_number=" + final_serial_number + "]";
	}




	public String getSerial_number() {
		return Serial_number;
	}

	public void setSerial_number(String serial_number) {
		Serial_number = serial_number;
	}

	public String getSerial_number_3rd() {
		return Serial_number_3rd;
	}

	public void setSerial_number_3rd(String serial_number_3rd) {
		Serial_number_3rd = serial_number_3rd;
	}

	public String getFinal_serial_number() {
		return final_serial_number;
	}

	public void setFinal_serial_number(String final_serial_number) {
		this.final_serial_number = final_serial_number;
	}
    
    
    
    
    
    
    

    
}