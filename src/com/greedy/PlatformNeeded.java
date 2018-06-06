package com.greedy;

import java.util.Arrays;

public class PlatformNeeded {
    public static void getPlatformNeeded(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 0;
        int max = -999;
        //merge process of merge sort
        int l = 0, r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[l] < dep[r]) {
                plat_needed++; //arrival adds
                l++;
                if (max < plat_needed)
                    max = plat_needed;

            } else {
                plat_needed--; //departure removes
                r++;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        getPlatformNeeded(arr, dep);
    }
}
//    Time     Event Type     Total Platforms Needed at this Time
//        9:00       Arrival                  1
//        9:10       Departure                0
//        9:40       Arrival                  1
//        9:50       Arrival                  2
//        11:00      Arrival                  3
//        11:20      Departure                2
//        11:30      Departure                1
//        12:00      Departure                0
//        15:00      Arrival                  1
//        18:00      Arrival                  2
//        19:00      Departure                1
//        20:00      Departure                0