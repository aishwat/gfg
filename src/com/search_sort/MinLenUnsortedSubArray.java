package com.search_sort;

import java.util.Arrays;

public class MinLenUnsortedSubArray {
    public static void getMinLenUnsortedArray(int a[]) {
        int s = 0, e = a.length - 1;
        //first get points breaking pattern
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                s = i;
                break;
            }
        }
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                e = i;
                break;
            }
        }
        //now check if max and min inside s->e affect outside subarray
        int max = 0;
        int min = 9999;
        for (int i = s; i <= e; i++) {
            if (max < a[i])
                max = a[i];
            if (min > a[i])
                min = a[i];
        }
        System.out.printf("max:%d min:%d", max, min);
        for (int i = 0; i < s; i++) {
            if (a[i] > min) {
                s = i;
                break;
            }

        }
        for (int i = e + 1; i < a.length; i++) {
            if (a[i] < max) {
                e = i;
                break;
            }
        }
        System.out.printf("\ns:%d e:%d", s, e);
        int sub[] = Arrays.copyOfRange(a, s, e);
        System.out.printf("\nsubarray:%s ", Arrays.toString(sub));

    }

    public static void main(String[] args) {
        int a[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        getMinLenUnsortedArray(a);
    }
}
