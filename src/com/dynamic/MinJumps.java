package com.dynamic;

import java.util.Arrays;

public class MinJumps {
    public static void getMinJumps(int a[]) {
        int min[] = new int[a.length];
        int p[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            min[i] = 99;
            p[i] = i;
        }
        min[0]=0;
        p[0]=-1;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + a[j] >= i && min[j] + 1 < min[i]) {//can reach i from j and steps to j+1 < min[i]
                    min[i] = min[j] + 1;
                    p[i] = j;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(min));
        System.out.println(Arrays.toString(p));

        int i = a.length - 1;
        while (i > 0) {
            System.out.printf("%d <- " , a[i]);
            i = p[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        getMinJumps(arr);
    }
}
