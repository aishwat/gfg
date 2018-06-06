package com.search_sort;

import java.util.Arrays;

public class Insertion {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j+1] = key;
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 4, 3, 2, 1};
        sort(a);
    }
}
