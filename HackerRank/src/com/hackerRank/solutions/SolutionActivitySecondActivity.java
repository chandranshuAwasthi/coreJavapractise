package com.hackerRank.solutions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionActivitySecondActivity {


    public static double findMedian(int a[]) {
        int n = a.length;
        if (n % 2 != 0)
            return (double) a[n / 2];
        return (double) (a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }

    static int activityNotifications(int[] expenditure, int d) {

        int totalNotification = 0;

        for (int i = d; i < expenditure.length; i++) {
            int[] arrayOfTransaction = new int[d];
            int k = 0;
            for (int j = i - 1; j >= i - d; j--) {
                arrayOfTransaction[k] = expenditure[j];
                k++;
            }
            Arrays.parallelSort(arrayOfTransaction);

            double median = findMedian(arrayOfTransaction);
            if (expenditure[i] >= 2.0 * median) {
                totalNotification += 1;
            }
//            if (arrayOfTransaction.length % 2 == 0) {
//                //int median= arrayOfTransaction.length/2;
//                if ((arrayOfTransaction[arrayOfTransaction.length / 2] + arrayOfTransaction[arrayOfTransaction.length / 2 - 1])  * 2 <= expenditure[i]) {
//                    totalNotification = totalNotification + 1;
//                }
//            } else {
//                if (arrayOfTransaction[arrayOfTransaction.length / 2 ] * 2 <= expenditure[i]) {
//                    totalNotification = totalNotification + 1;
//                }
//            }
        }
        return totalNotification;
    }
    static File file =
            new File("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\SolutionActivityNotification_usecase.txt");

    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(file);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\611263856\\GRADLE_WORKSPACE\\WLMS2Client_package\\SolutionActivityNotification_chandranshu_third.txt"));
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
    }
}
