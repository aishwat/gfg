package com.search_sort;

import java.util.Arrays;

public class Wave {
    public static void formWave(int a[]) {
        for (int i = 0; i < a.length; i = i + 2) {
            if (i - 1 > 0 && a[i - 1] > a[i])
                swap(a, i, i - 1);
            if (i + 1 < a.length && a[i + 1] > a[i])
                swap(a, i, i + 1);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        formWave(arr);
        System.out.println(Arrays.toString(arr));
    }
}
