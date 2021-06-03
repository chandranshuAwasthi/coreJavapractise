package com.hackerRank.solutions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SolutionForRotation {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] arr, int numberOfrotation) {
        if (arr.length == 0 || numberOfrotation == 0) {
            return arr;
        }
        int[] rotatedItems = new int[numberOfrotation];
        //int i;
        for (int i = 0; i < arr.length ; i++) {
            if (i < numberOfrotation) {
                System.out.println(arr[i]);
                rotatedItems[i] = arr[i];
                continue;
            }
            arr[i - numberOfrotation] = arr[i];
        }

        for (int k = 0; k < rotatedItems.length; k++) {
            arr[arr.length-numberOfrotation+k] = rotatedItems[k];
        }
        return arr;
    }


    static File file =
            new File("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\read_rotation.txt");


    // private static final Scanner scanner = new Scanner(file);

    public static void main(String[] args) throws IOException {

        final Scanner scanner = new Scanner(file);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\write_rotaion.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            //  System.out.println(aItem);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
