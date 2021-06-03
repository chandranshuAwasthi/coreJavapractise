package com.hackerRank.solutions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ActivityNotificationValue {

    static File file =
            new File("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\SolutionActivityNotification_usecase.txt");


    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\SolutionActivityNotification_output_2.txt"));
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
       /* {
            System.out.println("First One");
            int[] value = {4, 5, 6, 6, 10};
            int newValueToAdd = 9;
            int indexToIgnore = doBinarySearch(6,value);
            System.out.println("IndexToIgnore :"+ indexToIgnore);
            int newArrayLength = 5;
            int[] arrayToUseInNextNotification = IgnoreOneElementWhileDoingMergeSort(newValueToAdd, value, newArrayLength, indexToIgnore);
            IntConsumer intConsumer = value1 -> {
                System.out.println(arrayToUseInNextNotification[value1]);
            };
            IntStream.range(0, 5).forEach(intConsumer);

        }

        {
            System.out.println("Second One");
            int[] value = {4, 5, 6, 6, 10};
            int newValueToAdd = 3;
            int indexToIgnore = doBinarySearch(6,value);
            System.out.println("IndexToIgnore :"+ indexToIgnore);
            int newArrayLength = 5;
            int[] arrayToUseInNextNotification = IgnoreOneElementWhileDoingMergeSort(newValueToAdd, value, newArrayLength, indexToIgnore);
            IntConsumer intConsumer = value1 -> {
                System.out.println(arrayToUseInNextNotification[value1]);
            };
            IntStream.range(0, 5).forEach(intConsumer);

        }


        {
            System.out.println("Third One");
            int[] value = {4, 5, 6, 6, 10};
            int newValueToAdd = 3;
            int indexToIgnore = doBinarySearch(10,value);
            System.out.println("IndexToIgnore :"+ indexToIgnore);
            int newArrayLength = 5;
            int[] arrayToUseInNextNotification = IgnoreOneElementWhileDoingMergeSort(newValueToAdd, value, newArrayLength, indexToIgnore);
            IntConsumer intConsumer = value1 -> {
                System.out.println(arrayToUseInNextNotification[value1]);
            };
            IntStream.range(0, 5).forEach(intConsumer);

        }
*/
    }

    public static double findMedian(int a[]) {
        int n = a.length;
        if (n % 2 != 0)
            return (double) a[n / 2];

        return (double) (a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int activityNotifications(int[] expenditure, int d) {
        if (d >= expenditure.length) return 0;

        int numNotifications = 0;
        int[] trailingArr = new int[d];
        for (int i = 0; i < trailingArr.length; i++) {
            trailingArr[i] = expenditure[i];
        }
        Arrays.sort(trailingArr);
        for (int i = d; i < expenditure.length; i++) {
            double median = findMedian(trailingArr);
            if (expenditure[i] >= 2.0 * median) {
                numNotifications += 1;
            }
            int nextToRemoveElement = expenditure[i - d];
            int toInsertElement = expenditure[i];
            adjustTrailingArray(trailingArr, nextToRemoveElement, toInsertElement);
        }
        return numNotifications;
    }

    //This whole thing is O(d) time. Note that we are not sorting again as trailing array was already sorted
    // as preprocessing and now only one new element has to find its position in sorted array.

    private static void adjustTrailingArray(int[] trailingArr, int elementToRemove, int elementToInsert) {
        if (elementToInsert == elementToRemove) return;
        int foundIndex = 0;

        //The first element of unsorted trailing array will move out of the sliding window
        //Since the trailing array was sorted by us, we have lost the position of its first element in original array.
        //Hence, I search linearly for it and replace it with the new element.

        while (foundIndex < trailingArr.length) {
            if (trailingArr[foundIndex] != elementToRemove) {
                foundIndex++;
            } else {
                trailingArr[foundIndex] = elementToInsert;
                break;
            }
        }

        //Now we bubble the new element just inserted using bubble sort to left/right based on whether it was bigger
        //or smaller than the element that got removed.

        if (elementToInsert > elementToRemove) {
            int i = foundIndex;
            while (i < trailingArr.length - 1) {
                if (trailingArr[i] > trailingArr[i + 1]) {
                    swap(trailingArr, i, i + 1);
                    i += 1;
                } else break;
            }
        } else {
            int i = foundIndex;
            while (i > 0) {
                if (trailingArr[i] < trailingArr[i - 1]) {
                    swap(trailingArr, i, i - 1);
                    i -= 1;
                } else break;
            }
        }
    }

}
