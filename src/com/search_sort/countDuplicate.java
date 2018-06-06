package com.search_sort;

public class countDuplicate {
    public static void getFirst(int[] a, int key, int l, int r) {
        int mid = 0;
        while (r - l > 1) {
            mid = l + r >>> 1;
            if (a[mid] == key && a[mid - 1] < key) {
                System.out.println(mid);
            } else if (a[mid] > key)
                r = mid;
            else
                l = mid;
        }

    }

    public static void main(String[] args) {
        //5//10
        int[] a = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2};
        getFirst(a, 1, 0, a.length - 1);
        System.out.printf("\n");
    }
}
