package com.search_sort;

import java.util.Arrays;

public class Count {
    public static int[] sort(int[] a) {

//        IntSummaryStatistics stat = Arrays.stream(a).summaryStatistics();
//        int max = stat.getMax();
        int c[] = new int[10]; //assuming 0 to 9
        int b[] = new int[a.length];

        Arrays.fill(c, 0);
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }
        for (int i = 1; i < 10; i++) {
            c[i] += c[i - 1];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]]--;
        }
        return b;
    }

    public static void main(String[] args) {
        int a[] = {6, 5, 4, 3, 2, 1};
        int b[] = sort(a);

        System.out.println(Arrays.toString(b));
    }
}
