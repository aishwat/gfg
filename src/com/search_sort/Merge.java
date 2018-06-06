package com.search_sort;

import java.util.Arrays;

public class Merge {
    static int inv_count = 0;
    public static void mergeSort(int a[], int l, int r) {

        if (l < r) {
            int m = (l + r) >>> 1;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void merge(int a[], int l, int m, int r) {
        int left[] = Arrays.copyOfRange(a, l, m + 1);
        int right[] = Arrays.copyOfRange(a, m + 1, r + 1);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int _l = 0, _r = 0, k = 0;
        System.out.printf("l:%d m:%d r:%d\n", l, m, r);
        while (_l < left.length && _r < right.length) {
            if (left[_l] < right[_r]) {
                a[k + l] = left[_l];
                _l++;
            } else {
                inv_count += left.length-_l;
                a[k + l] = right[_r];
                _r++;
            }
            k++;
            System.out.printf("_l:%d k:%d _r:%d\n", _l, k, _r);
        }
        while (_l < left.length) {
            a[k + l] = left[_l];
            k++;
            _l++;
        }
        while (_r < right.length) {
            a[k + _r] = right[_r];
            k++;
            _r++;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int a[] = {6, 5, 4, 3, 2, 1};
        mergeSort(a,0,a.length-1);
        System.out.printf("\ninv_count:%d",inv_count);
//        mergeSort(a, 0, a.length - 1);
//        merge(a, 0, (a.length - 1) / 2, a.length - 1);

    }
}
