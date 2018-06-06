package com.search_sort;

import java.util.*;

public class KSorted {

    public static void sort(int a[], int k) {
        List list = new ArrayList(a.length);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            minHeap.add(a[i]);
        }
        System.out.println("");
        for (int i = 0; i + k < a.length; i++) {
            list.add(minHeap.poll());
            minHeap.add(a[i + k]);
        }
        for (int i = k; i > 0; i--) {
            list.add(minHeap.poll());
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        int[] a = {2, 6, 3, 12, 56, 8};
        sort(a, 3);
    }

}
