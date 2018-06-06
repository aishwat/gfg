package com.dynamic;

import java.util.Arrays;

public class Biotonic {
    public static int[] getLIS(int a[]) {
        int tmp[] = new int[a.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 1;
        }
        for (int j = 1; j < a.length; j++) {
            for (int i = 0; i < j; i++) {
                if (a[i] < a[j] && tmp[j] < tmp[i] + 1) {
                    tmp[j] = tmp[i] + 1;
                }
            }
        }
        return tmp;
    }

    public static int[] getLDS(int[] a) {
        int tmp[] = new int[a.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 1;
        }
        //decreasing
        for (int j = a.length - 2; j >= 0; j--) {
            for (int i = a.length - 1; i > j; i--) {
                if (a[i] < a[j] && tmp[j] < tmp[i] + 1) {
                    tmp[j] = tmp[i] + 1;
                }
            }
        }
        return tmp;
    }

    public static void getLongestBiotonicSubseq(int[] a) {
        int lis[] = getLIS(a);
        int lds[] = getLDS(a);
        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(lds));

        int max = -1;
        for (int i = 0; i < a.length; i++) {
            if(max< (lis[i]+lds[i]-1))
                max = (lis[i]+lds[i]-1);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
        getLongestBiotonicSubseq(arr);
    }
}
