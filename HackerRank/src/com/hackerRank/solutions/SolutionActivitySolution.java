package com.hackerRank.solutions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SolutionActivitySolution {


    public static double findMedianLogic(int a[]) {
        int n = a.length;
        if (n % 2 != 0)
            return (double) a[n / 2];

        return (double) (a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int totalNotification = 0;
        int[] arrayOfTransaction = new int[d];
        for (int i = 0; i < d; i++) {
            arrayOfTransaction[i] = expenditure[i];
        }
        Arrays.sort(arrayOfTransaction);
        for (int i = d; i < expenditure.length; i++) {
            double median = findMedianLogic(arrayOfTransaction);
            if (expenditure[i] >= 2.0 * median) {
                totalNotification += 1;
            }
            int k = doBinarySearch(expenditure[i - d], arrayOfTransaction);

            //expenditure[i]=valueToIgnore
            //expenditure[i-d]=nextvalueToAdd
            int[] newValue = IgnoreOneElementWhileDoingMergeSort(expenditure[i], arrayOfTransaction, k, expenditure[i - d]);

            arrayOfTransaction = newValue;
        }
        return totalNotification;


    }


    static int activityNotifications_secondType(int[] expenditure, int d) {
        int totalNotification = 0;
        int[] arrayOfTransaction = new int[d];
        for (int i = 0; i < d; i++) {
            arrayOfTransaction[i] = expenditure[i];
        }
        Arrays.sort(arrayOfTransaction);
        for (int i = d; i < expenditure.length; i++) {
            double median = findMedianLogic(arrayOfTransaction);
            if (expenditure[i] >= 2.0 * median) {
                totalNotification += 1;
            }
            //expenditure[i]=valueToIgnore
            //expenditure[i-d]=nextvalueToAdd
            IgnoreFirstAndAddNextElement(expenditure[i], arrayOfTransaction, expenditure[i - d]);

        }
        return totalNotification;
    }


    private static void IgnoreFirstAndAddNextElement(int nextValueToAdd, int[] priorTransaction, int priorValueToIgnore) {
        if (nextValueToAdd == priorValueToIgnore) {
            return;
        }
        int k = doBinarySearch(priorValueToIgnore, priorTransaction);
        priorTransaction[k] = nextValueToAdd;
        if (nextValueToAdd > priorValueToIgnore) {
            //Control will come inside and we have to adjust the newly item towards right side from the index found for the value to ignore
            while (k < priorTransaction.length-1) {
                if (priorTransaction[k] > priorTransaction[k + 1]) {
                    swap(priorTransaction, k, k + 1);
                    k++;
                } else {
                    break;
                }

            }
        } else {
            while (k > 0) {
                if (priorTransaction[k] < priorTransaction[k - 1]) {
                    swap(priorTransaction, k, k - 1);
                    k--;
                } else {
                    break;
                }

            }
        }


    }

    private static void swap(int[] priorTransaction, int k, int j) {
        int temp = priorTransaction[k];
        priorTransaction[k] = priorTransaction[j];
        priorTransaction[j] = temp;

    }


    // Complete the activityNotifications function below.
   /* static int activityNotifications(int[] expenditure, int d) {
        int totalNotification = 0;
        int[] arrayOfTransaction = new int[d];

        for (int i = 0; i < d; i++) {
            arrayOfTransaction[i] = expenditure[i];
        }
        Arrays.sort(arrayOfTransaction);
        for (int i = d; i < expenditure.length; i++) {
            double median = findMedian(arrayOfTransaction);
            if (expenditure[i] >= 2.0 * median) {
                totalNotification += 1;
            }
            int k = doBinarySearch(expenditure[i - d], arrayOfTransaction);
            int []  transactionArray= ignoreFirstAndAddNextElement(expenditure[i], arrayOfTransaction, d, expenditure[i - d]);
            arrayOfTransaction = transactionArray;
        }
        return totalNotification;


    }
*/

    //  System.out.println(sj1);

    // return totalNotification;


    private static int[] IgnoreOneElementWhileDoingMergeSort(int k, int[] arrayOfTransaction, int countToRaiseNotification, int valueToIgnore) {
        int[] newArrayLength = new int[countToRaiseNotification];
        int[] a1 = new int[1];
        a1[0] = k;
        int y = 0;
        int z = 0;
        int x = 0;
        int firstValue = 0;

        //int length=arrayOfTransaction.length;
        //int nextArray=a1.length;
        while (y < arrayOfTransaction.length && z < a1.length) {
            if (arrayOfTransaction[y] < a1[z]) {
                try {
                    if (!(arrayOfTransaction[y] == valueToIgnore && firstValue == 0)) {
                        newArrayLength[x] = arrayOfTransaction[y];
                        x++;
                    } else {
                        firstValue++;
                    }
                    y++;
                } catch (Exception ee) {

                    ee.printStackTrace();
                    System.out.println("Problem in executing");
                }

            } else if (arrayOfTransaction[y] == a1[z]) {
                if (!(arrayOfTransaction[y] == valueToIgnore && firstValue == 0)) {
                    newArrayLength[x] = arrayOfTransaction[y];
                    y++;
                    x++;
                    newArrayLength[x] = a1[z];
                    z++;
                    x++;
                } else {
                    firstValue++;
                    y++;
                }
            } else {
                try {
                    if (arrayOfTransaction[y] > a1[z]) {
                        newArrayLength[x] = a1[z];
                        x++;
                        z++;
                    }
                } catch (Exception exe) {
                    System.out.println("Value of y :" + y);
                }

            }
        }
        while (y < arrayOfTransaction.length) {
            if (!(arrayOfTransaction[y] == valueToIgnore && firstValue == 0)) {
                newArrayLength[x] = arrayOfTransaction[y];
                x++;
            } else {
                firstValue++;
            }
            y++;
        }
        while (z < a1.length) {
            newArrayLength[x] = a1[0];
            z++;
        }
        return newArrayLength;
    }

    private static int doBinarySearch(int valueToSearch, int[] arrayOfTransaction) {


        /*int mid = 0;
        if (arrayOfTransaction.length % 2 == 0) {
            mid = arrayOfTransaction.length / 2 -1;
        } else if (arrayOfTransaction.length % 2 == 1) {
            mid = arrayOfTransaction.length / 2;
        }
        if(arrayOfTransaction[mid]==valueToSearch){
            return mid;
        }else if(valueToSearch>arrayOfTransaction[mid]) {
            int [] arrayOfTransactions=new int[arrayOfTransaction.length-(mid+1)];
            IntStream.range(mid + 1, arrayOfTransaction.length).forEach(value -> {
                arrayOfTransactions[value] =arrayOfTransaction[value];
            });
            doBinarySearch(valueToSearch,arrayOfTransactions);
        }else if(valueToSearch<arrayOfTransaction[mid]){
            int [] arrayOfTransactions=new int[mid];
            IntStream.range(0,mid+1).forEach(value -> {
                arrayOfTransactions[value] =arrayOfTransaction[value];
            });
            doBinarySearch(valueToSearch,arrayOfTransactions);
        }*/
        return Arrays.binarySearch(arrayOfTransaction, valueToSearch);
    }



    static File file =
            new File("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\SolutionActivityNotification_usecase.txt");


    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\SolutionActivityNotification_chandranshu_fifth.txt"));
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

        int result = activityNotifications_secondType(expenditure, d);

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
}
