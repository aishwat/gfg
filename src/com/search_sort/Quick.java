package com.search_sort;

import java.util.Arrays;

public class Quick {
    public static void sort_iterative(int[] a, int low, int high) {
        int[] stack = new int[high - low + 1];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;
        while (top > 0) {
            int h = stack[top--];
            int l = stack[top--];
            int pi = partition(a, l, h);
            if(pi-1>l){
                stack[++top]=l;
                stack[++top]=pi-1;
            }
            if(pi+1<h){
                stack[++top]=pi+1;
                stack[++top]=h;
            }
        }
    }

    public static void sort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            sort(a, low, pi - 1);
            sort(a, pi + 1, high);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j); //forcefully put it at i
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int a[] = {6, 5, 4, 3, 2, 1};
        sort_iterative(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
