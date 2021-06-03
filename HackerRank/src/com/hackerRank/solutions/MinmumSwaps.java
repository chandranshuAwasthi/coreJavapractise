package com.hackerRank.solutions;

import java.util.Arrays;

public class MinmumSwaps {


    static int minimumSwaps(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 != arr[i]) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (i + 1 == arr[j]) {
                        int k = arr[i];
                        arr[i] = arr[j];
                        arr[j] = k;
                        count++;
                        break;
                    }
                }

            }
        }

        /*List<Integer> listOfValues = new ArrayList<Integer>();
        int[] array = IntStream.range(1, arr.length).filter(value -> value + 1 != arr[value]).;
        for (int k :
                array) {
            System.out.println("K : " + k);
        }

*/
        return count;
    }


    public static void main(String[] args) {

        int[] arr = {7, 1, 3, 2, 4, 5, 6};
        int k = minimumSwaps(arr);
        System.out.println(k);
        Arrays.stream(arr).forEach((int value) -> {
            //  System.out.println(value);
        });
    }
}
