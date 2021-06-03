package com.hackerRank.solutions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FindingBiggestFourSquare {

    static File file =
            new File("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\read.txt");


    public static void main(String[] args) throws IOException {

        final Scanner scanner = new Scanner(file);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\text.txt"));

        int[][] arr = new int[6][6];


       /* while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
    }*/

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                System.out.println("i :" + i + " j :" + j);
                System.out.println("arrItem" + arrItem);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();        //initialization of array


    }

    private static int hourglassSum(int[][] arr) {
        Map<Integer, Integer> mapOfvalues = new HashMap<Integer, Integer>();
        int initialvalue = 1;
        if (arr.length == 6 && arr != null) {
            for (int i = 0; i <= arr.length - 3; i++) {
                for (int k = 0; k <= arr.length - 3; k++) {
                    // System.out.println("i :" + i + " j :" + k);
                    //gettheSum(getTheSumOfEachHourlySquare(i, k, arr));
                    mapOfvalues.put(initialvalue, gettheSum(getTheSumOfEachHourlySquare(i, k, arr)));
                    initialvalue++;
                }
            }
        }
        //System.out.println("mapOfvalues.size() :"+mapOfvalues.size());

        return Collections.max(mapOfvalues.values());
    }

    private static int gettheSum(int[] value) {
        return value[0] + value[1] + value[2] + value[4] + value[6] + value[7] + value[8];

    }

    public static int[] getTheSumOfEachHourlySquare(int veticalCoordinate, int horizontalCoordinate, int[][] value) {
        //System.out.println("veticalCoordinate : " + veticalCoordinate + " horizontalCoordinate : " + horizontalCoordinate);
        int[] valuesOfsquare = new int[9];
        int i = 0;
        for (int k = veticalCoordinate; k <= veticalCoordinate + 2; k++) {
            for (int j = horizontalCoordinate; j <= horizontalCoordinate + 2; j++) {
                //System.out.println("getTheSumOfEachHourlySquare " + "K :" + k + " j :" + j);
                valuesOfsquare[i] = value[k][j];
                i++;
            }
        }
        return valuesOfsquare;
    }
}
