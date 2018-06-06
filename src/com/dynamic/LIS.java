package com.dynamic;

import java.util.Arrays;

public class LIS {
    //n2
    public static void getLIS(int a[]) {
        int[] LIS = new int[a.length];
        Arrays.fill(LIS, 1);

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;
            }
        }
        int max = LIS[0];
        for (int i = 0; i < LIS.length; i++) {
            if (max < LIS[i])
                max = LIS[i];
        }
        System.out.println("LIS " + max);
    }

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        getLIS(arr);
    }
}
