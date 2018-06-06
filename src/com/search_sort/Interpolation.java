package com.search_sort;

public class Interpolation {
    public static int find(int key, int a[], int lo, int hi) {
        int m, pos = lo, rise;

        while (lo <= hi && key < a[hi] && key > a[lo]) {
            m = (hi - lo) / (a[hi] - a[lo]);
            rise = key - a[lo];
            pos = (m * rise) + lo;

            if (a[pos] == key)
                return pos;
            else if (a[pos] < key) { //need to look right
                lo = pos + 1;
            } else {
                hi = pos - 1;
            }
            System.out.printf("lo:%d hi:%d\n", lo, hi);

        }
        System.out.println("not found");
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 4, 5, 6};
        int pos = find(3, a, 0, a.length - 1);
        System.out.printf("found at: %d\n", pos);
    }
}
