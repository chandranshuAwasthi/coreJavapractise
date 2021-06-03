import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MaxRangeSum {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
				
		Scanner fileScanner = new Scanner(System.in);
		
		while(fileScanner.hasNextLine()){
			String line = fileScanner.nextLine();
			if(!line.equalsIgnoreCase("")){
				String elements[] = line.split(";");
				int range = Integer.parseInt(elements[0]);
				String gainsLosses[] = elements[1].split("\\s");
				int gAndLs[] = new int[gainsLosses.length];
				
				for(int i = 0; i < gainsLosses.length; i++){
					int temp = Integer.parseInt(gainsLosses[i]);
					gAndLs[i] = temp;
				}
				
				int maxReturn = Integer.MIN_VALUE;
				
				int maxIndexStart = gAndLs.length - range;
				
				for(int i = 0; i <= maxIndexStart; i++){
					int tempVal = 0;
					for(int j = 0; j < range; j++){
						tempVal += gAndLs[i + j];
					}
					if(tempVal > maxReturn){
						maxReturn = tempVal;
					}
				}
				if(maxReturn < 0){
					maxReturn = 0;
				}
				System.out.println(maxReturn);
				
			}
		}
		
		fileScanner.close();

	}
	
}