package com.search_sort;

public class Common {
    public static void getCommon(int[] a, int[] b, int[] c) {
        int x = 0, y = 0, z = 0;
        while (x < a.length && y < b.length && z < c.length) {
            if (a[x] == b[y] && b[y] == c[z]) {
                System.out.printf("\ncommon:%d", a[x]);
                x++;
                y++;
                z++;
            } else if (a[x] < b[y] || a[x] < c[z]) { //x<y || x<z
                x++;
            } else if (b[y] < c[z] || b[y] < a[x]) { //y<x || y<z
                y++;
            } else if (c[z] < a[x] || c[z] < b[y]) { //z<x || z<y
                z++;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 10, 20, 40, 80};
        int b[] = {6, 7, 20, 80, 100};
        int c[] = {3, 4, 15, 20, 30, 70, 80, 120};
        getCommon(a, b, c);
    }

}
