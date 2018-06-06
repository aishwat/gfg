package com.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NumericKeypad {
    public static void getCount(int n) {
        int a[] = new int[10];
        int b[] = new int[10];
        Arrays.fill(a, 1);
        Arrays.fill(b, 1);

        for (int i = 1; i <= n; i++) {
            b[0] = a[0] + a[8];
            b[1] = a[1] + a[2] + a[4];
            b[2] = a[2] + a[1] + a[3] + a[5];
            b[3] = a[3] + a[2] + a[6];
            b[4] = a[4] + a[1] + a[5] + a[7];
            b[5] = a[5] + a[2] + a[4] + a[6] + a[8];
            b[6] = a[6] + a[3] + a[5] + a[9];
            b[7] = a[7] + a[4] + a[8];
            b[8] = a[8] + a[5] + a[7] + a[9] + a[0];
            b[9] = a[9] + a[6] + a[8];

            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum = sum + b[j];
            }
            System.out.println(sum + " ");
            for (int j = 0; j < 10; j++) {
                a[j] = b[j]; //transfer b's to a's for next n digit count
            }

        }
    }

    public static void main(String[] args) {
        getCount(5);
    }
}
