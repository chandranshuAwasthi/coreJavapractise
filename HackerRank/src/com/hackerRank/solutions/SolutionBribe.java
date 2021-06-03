package com.hackerRank.solutions;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SolutionBribe {

    // Complete the minimumBribes function below.
//    static void minimumBribes(int[] q) {
//
//        int bribeCount = 0;
//        if (q.length == 0) {
//            return;
//        }
//        for (int i = 0; i < q.length; i++) {
//            if (q[i] - i > 3 || q[i] - i < -3) {
//                bribeCount=-1;
//                break;
//            }
//            if(q[i] - i == -1 || q[i] - i == -2 || q[i] - i == -3){
//                continue;
//            }
//            if (q[i] - i == 1) {
//                bribeCount = bribeCount;
//            } else if (q[i] - i == 2) {
//                bribeCount = bribeCount + 1;
//            } else if (q[i] - i == 3) {
//                bribeCount = bribeCount + 2;
//            }
//
//        }
//        System.out.println(bribeCount==-1?"Too chaotic":bribeCount);
//
//    }


    static void minimumBribes(int[] q) {

        int[] intArray = new int[q.length];
        IntStream.range(1, q.length+1).forEach(value -> intArray[value - 1] = value);
        int bribeCount = 0;
        for (int i = 0; i < q.length; i++) {
            if (intArray[i] == q[i]) {


            } else if (intArray[i+1]  == q[i]) {
                int value = intArray[i + 1];
                intArray[i + 1] = intArray[i];
                intArray[i] = value;
                bribeCount = bribeCount + 1;
            } else if (intArray[i+2]  == q[i]) {
                int secondLastValue = intArray[i + 2];
                intArray[i + 2] = intArray[i + 1];
                intArray[i + 1] = secondLastValue;
                int firstLastValue = intArray[i];
                intArray[i] = intArray[i + 1];
                intArray[i + 1] = firstLastValue;
                bribeCount = bribeCount + 2;
            } else {
                bribeCount = -1;
                break;
            }


        }
        System.out.println(bribeCount == -1 ? "Too chaotic" : bribeCount);


//        int j = 1;
//        int bribeCount = 0;
//        for (int i = 0; i < q.length; i++) {
//            if (j == q[i]) {
//
//            } else if (j+1 == q[i]) {
//                int value = q[i + 1];
//                q[i + 1] = q[i];
//                q[i] = value;
//                bribeCount=bribeCount+1;
//            } else if (j+2 == q[i]) {
//                int secondLastValue = q[i + 2];
//                q[i + 2] = q[i + 1];
//                q[i + 1] = secondLastValue;
//                int firstLastValue=q[i];
//                q[i]=q[i+1];
//                q[i+1]=firstLastValue;
//                bribeCount=bribeCount+2;
//            } else {
//                bribeCount=-1;
//                break;
//            }
//            j++;
//        }
//
//        //System.out.println("Too chaotic");
//        System.out.println(bribeCount==-1?"Too chaotic":bribeCount);


//        int bribeCount = 0;
//        if (q.length == 0) {
//            return;
//        }
//        for (int i = 0; i < q.length; i++) {
//            if (q[i] - i > 3 || q[i] - i < -3) {
//                bribeCount = -1;
//                break;
//            }
//            if (q[i] - i == -1 || q[i] - i == -2 || q[i] - i == -3) {
//                continue;
//            }
//            if (q[i] - i == 1) {
//                bribeCount = bribeCount;
//            } else if (q[i] - i == 2) {
//                bribeCount = bribeCount + 1;
//            } else if (q[i] - i == 3) {
//                bribeCount = bribeCount + 2;
//            }
//
//        }
//        System.out.println(bribeCount == -1 ? "Too chaotic" : bribeCount);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            int n = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            int[] q = new int[n];
//
//            String[] qItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int i = 0; i < n; i++) {
//                int qItem = Integer.parseInt(qItems[i]);
//                q[i] = qItem;
//            }
//
//            minimumBribes(q);
//        }
//
//        scanner.close();


        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(q);
    }
}
