package com.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinCoins {
    public static void getMinCoins(int coins[], int V) {
        int T[][] = new int[coins.length][V + 1];
        for (int i = 0; i < coins.length; i++) {
            T[i][0] = 0;
        }
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == 0)
                    T[i][j] = j;
                else if (coins[i] > j)
                    T[i][j] = T[i - 1][j];
                else {
                    T[i][j] = Math.min(T[i - 1][j], 1 + T[i][j - coins[i]]);
                }
            }
        }
        print_arr(T);
    }

    public static void print_arr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int V = 11;
        getMinCoins(coins, V);
    }
}
