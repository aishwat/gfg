package com.dynamic;

import java.util.Arrays;

public class MaxSumIncSubseq {
    public static void getMaxSumIncSubseq(int[] a) {
        int tmp[] = Arrays.copyOf(a, a.length);

        for (int j = 1; j < a.length; j++) {
            for (int i = 0; i < j; i++) {
                if (a[i] < a[j] && tmp[j] < tmp[i] + a[j])
                    tmp[j] = tmp[i] + a[j];
            }
        }
        System.out.println(Arrays.toString(tmp));
    }

    public static void main(String[] args) {
        int arr[] = {1, 101, 2, 3, 100, 4, 5};
        getMaxSumIncSubseq(arr);
    }
}
