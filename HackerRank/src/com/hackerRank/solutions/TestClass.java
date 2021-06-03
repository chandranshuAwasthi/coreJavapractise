package com.hackerRank.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {
    static int minParkingSpaces(int[][] parkingStartEndTimes) {
        List<Boolean> slots = new ArrayList<>();
        int slotsRequiredCount = 0;
        int busySlotCount = 0;
        int freeSlotCount = 0;
        List<Integer> consumedStartTimeList = new ArrayList<>();
        List<Integer> consumedEndTimeList = new ArrayList<>();
        List<int[]> parkingStartEndTimesList = Arrays.asList(parkingStartEndTimes);
        for (int[] entry : parkingStartEndTimesList) {
            int startTime = entry[0];
            int endTime = entry[1];
//boolean startTimeAfterConsumedEndTime = false;
            for (int x = 0; x < consumedEndTimeList.size(); x++) {
                int listEntryEndTime = consumedEndTimeList.get(x);
                if (listEntryEndTime > startTime) {
                    //startTimeAfterConsumedEndTime = true;
                    freeSlotCount++;
                    busySlotCount--;
                    consumedEndTimeList.remove(x);
                }
            }
            if (freeSlotCount == 0) {
                slotsRequiredCount++;
                busySlotCount++;
            } else if (freeSlotCount > 0) {
                busySlotCount++;
            }
            consumedStartTimeList.add(startTime);
            consumedEndTimeList.add(endTime);
        }
        return slotsRequiredCount;

    }

    // DO NOT MODIFY ANYTHING BELOW THIS LINE!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[][] parkingStartEndTimeList = new int[n][2];
        String[] parkingStartEndTimes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
            for (int j = 0; j < parkingStartEndTime.length; j++) {
                parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
            }
        }

        int out = minParkingSpaces(parkingStartEndTimeList);
        System.out.println(out);

        wr.close();
        br.close();
    }
}