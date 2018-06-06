package com.dynamic;

public class MinCostPath {
    public static int minCost(int cost[][]) {
        int col = cost.length;
        int row = cost[0].length;
        int L[][] = new int[row][col];

//        for (int i = 1; i < row; i++) {
//            L[0][i] = cost[0][i] + L[0][i - 1];
//        }
//        for (int i = 1; i < row; i++) {
//            L[i][0] = cost[i][0] + L[i - 1][0];
//        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    L[0][0] = cost[0][0];
                else if (i == 0) {
                    L[i][j] = cost[i][j] + L[i][j - 1];
                } else if (j == 0) {
                    L[i][j] = cost[i][j] + L[i - 1][j];
                } else {
                    L[i][j] = min(L[i - 1][j - 1], L[i - 1][j], L[i][j - 1]) + cost[i][j];
                }
            }
        }
        return L[row - 1][col - 1];
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String args[]) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println("minimum cost to reach (2,2) = " +
                minCost(cost));
    }
}
