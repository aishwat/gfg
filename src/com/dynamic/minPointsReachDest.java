package com.dynamic;

public class minPointsReachDest {
    public static void getMinPointsToReachDest(int points[][]) {
        int R = 3, C = 3;
        int dp[][] = new int[R][C];
        dp[R - 1][C - 1] = points[R - 1][C - 1] > 0 ? 1 : Math.abs(points[R - 1][C - 1])
                + 1;
        //base row
        for (int i = R - 2; i >= 0; i--) {
            dp[i][C - 1] = Math.max(dp[i + 1][C - 1] - points[i][C - 1], 1);
        }
        //base col
        for (int i = C - 2; i >= 0; i--) {
            dp[R - 1][i] = Math.max(dp[R - 1][i + 1] - points[R - 1][i], 1);
        }

        for (int i = R - 2; i >= 0; i--) {
            for (int j = C - 2; j >= 0; j--) {
                int min_points = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min_points - points[i][j], 1);
            }
        }
        System.out.println(dp[0][0]);
        EditDistance.print_arr(dp);
    }

    public static void main(String[] args) {
        int points[][] = {{-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        getMinPointsToReachDest(points);
    }
}
