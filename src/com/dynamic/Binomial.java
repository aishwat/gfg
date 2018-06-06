package com.dynamic;

public class Binomial {
    public static void getBinomial(int n, int k) {
        int c[][] = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) { //in nck, k cant go above i
                if (i == j || j == 0)
                    c[i][j] = 1;
                else
                    c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= k; j++) {
//                System.out.printf("%d ", c[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(c[n][k]);
    }

    public static void main(String[] args) {
        getBinomial(5, 2);
    }
}
