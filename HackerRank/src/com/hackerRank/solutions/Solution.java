package com.hackerRank.solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        Map<Integer, Integer> mapOfvalues = new HashMap<Integer, Integer>();
        int initialvalue = 1;
        if (arr.length == 6 && arr != null) {
            for (int i = 0; i <= arr.length - 3; i++) {
                for (int k = 0; k <= arr.length - 3; k++) {
                    mapOfvalues.put(initialvalue, gettheSum(getTheSumOfEachHourlySquare(i, k, arr)));
                    initialvalue++;
                }
            }
        }
        //System.out.println("mapOfvalues.size() :"+mapOfvalues.size());
        Set<Integer> setOfvalues = mapOfvalues.keySet();
        return Collections.max(setOfvalues);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        int result = hourglassSum(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
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

    private static int gettheSum(int[] value) {
        return value[0] + value[1] + value[2] + value[4] + value[6] + value[7] + value[8];

    }

}
