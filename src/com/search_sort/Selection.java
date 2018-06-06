package com.search_sort;

import java.util.Arrays;

public class Selection {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length ; i++) {
            int min = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            swap(a, i, min);
//            System.out.printf("swapping: %d and %d\n", i , min);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {5, 4, 3, 2, 1};
        sort(a);
    }
}
