package com.search_sort;

import java.util.Arrays;

public class Radix {

    public static int[] countSort(int[] a, int exp) {
        int c[] = new int[10]; //assuming 0 to 9
        int b[] = new int[a.length];

        Arrays.fill(c, 0);
        for (int i = 0; i < a.length; i++) {
            c[(a[i] / exp) % 10]++;
        }
//        System.out.println(Arrays.toString(c));
        for (int i = 1; i < 10; i++) {
            c[i] += c[i - 1];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[(a[i] / exp) % 10] - 1] = a[i];
            c[(a[i] / exp) % 10]--;
        }

        return b;
    }

    public static void main(String[] args) {
        int a[] = {15, 14, 12, 11, 6, 5, 4, 3, 2, 1};
        int b[] = countSort(a, 1); //will do like (15/1)%10 = 5 , so all unit digits
        int c[] = countSort(b, 10); // will do like (15/10)%10 =1 so all ten's digits
        System.out.println(Arrays.toString(c));
    }
}
