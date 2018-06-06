package com.search_sort;

import java.util.Arrays;

public class Heap {
    public static void sort(int a[]) {
        buildMaxHeap(a);
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            heapify(a, 0, i);
            System.out.printf("i: %d arr: %s\n", i, Arrays.toString(a));
        }
    }

    public static void buildMaxHeap(int a[]) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, i, a.length);
        }
        System.out.printf("buildMaxHeap: %s\n", Arrays.toString(a));
    }

    public static void heapify(int a[], int root, int length) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int max = root;
        if (left < length && a[left] > a[max])
            max = left;
        if (right < length && a[right] > a[max])
            max = right;
        if (max != root) {
            swap(a, max, root);
            heapify(a, max, length);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
