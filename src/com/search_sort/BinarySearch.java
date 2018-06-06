package com.search_sort;

public class BinarySearch {
    public static int find(int key, int[] a, int l, int r) {

        while (l < r) {
            int mid = l + r >>> 1;

            if (a[mid] == key)
                return mid;
            else if (a[mid] > key)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static void floorAndCeil(int key, int[] a, int l, int r) {

        while (r - l > 1) { //terminating cond is imp , rest ceil floor can be figured out
            int mid = l + r >>> 1;
//            System.out.printf("l:%d m:%d r:%d\n", l, mid, r);
            if (a[mid] == key) {
//                System.out.println("exact element found");
                return;
            } else if (key < a[mid]) //floor lies in left
                r = mid;
            else
                l = mid;
        }
        System.out.printf("floor:%d ceil%d", a[l], a[r]);
    }

    public static int findMin(int[] a, int l, int r) {

        while (r - l > 1) {
            int mid = l + r >>> 1;
            System.out.printf("l:%d m:%d r:%d\n", l, mid, r);

            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
                System.out.printf("found at: %d", mid);
                return mid;
            } else if (a[mid] > a[r]) //floor lies in left
                l = mid;
            else
                r = mid;
        }
        return -1;
    }
    public static void main(String[] args) {
//        int a[] = {1, 2, 4, 5, 6};
//        int pos = find(3, a, 0, a.length - 1);
//        System.out.printf("pos: %d", pos);

//        floorAndCeil(4, a, 0, a.length - 1);
//        int a[] = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 1, 2, 3, 4};
//        findMin(a, 0, a.length - 1);

    }
}

