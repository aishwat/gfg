package com.search_sort;

public class KthSmallest {
    public static void getKthSmallest(int[] a, int k) {
        int p = partition(a, 0, a.length - 1);
        while (p != k) {
            if (p > k) { //need to look left
                p = partition(a,0,p-1 );
            }
            else { //look right
                p = partition(a,p+1,a.length-1);
            }
        }
        System.out.println(a[p]);
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < a.length; j++) {
            if (a[j] < pivot) {
                swap(a, ++i, j);
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
        int a[] = {7, 10, 4, 3, 20, 15};
        getKthSmallest(a, 3);
    }
}
