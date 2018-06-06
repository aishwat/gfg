package com.dynamic;

public class UglyNum {
    public static void getUglyNum(int n) {
        //factors - 2,3,5

        int ugly[] = new int[n + 1];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        int next_multiple_2 = 2;
        int next_multiple_3 = 3;
        int next_multiple_5 = 5;

        for (int i = 1; i <= n; i++) {
            int next = min(next_multiple_2, next_multiple_3, next_multiple_5);
            ugly[i] = next;

            if (next == next_multiple_2) {
                i2++;
                next_multiple_2 = ugly[i2] * 2;
            }
            if (next == next_multiple_3) {
                i3++;
                next_multiple_3 = ugly[i3] * 3;
            }
            if (next == next_multiple_5) {
                i5++;
                next_multiple_5 = ugly[i5] * 5;
            }
        }
        System.out.println(ugly[n]);
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }


    public static void main(String[] args) {
        getUglyNum(150);
    }
}
