package com.search_sort;

public class ClosestPair {
    public static void getClosestPair(int a[], int b[], int x) {
        int l = 0, r = b.length - 1;
        int diff = 999;
        int _l = 0, _r = 0;
        while (l < a.length && r > 0) {
            if (Math.abs(a[l] + b[r] - x) < diff) {
                diff = Math.abs(a[l] + b[r] - x);
                _l = l;
                _r = r;
            }
            if (a[l] + b[r] > x)
                r--;
            else
                l++;
        }
        System.out.printf("\nl:%d r:%d", _l, _r);
    }

    public static void main(String[] args) {
        int a[] = {1, 4, 5, 7};
        int b[] = {10, 20, 30, 40};
        int x = 38;
        getClosestPair(a, b, x);
    }
}
