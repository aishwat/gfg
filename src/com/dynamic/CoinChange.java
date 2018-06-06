package com.dynamic;

import java.util.Arrays;

public class CoinChange {
    public static void getCountWays(int coins[], int N) {
        int L[][] = new int[coins.length][N + 1];

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 1;
                else if (coins[i] > j)
                    L[i][j] = L[i - 1][j];
                else
                    L[i][j] = L[i - 1][j] + L[i][j - coins[i]];
            }
        }
        System.out.println(L[coins.length-1][N]);
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        int N = 4;
        getCountWays(coins, N);
    }
}
