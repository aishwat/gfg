package com.dynamic;

public class Knapsack {
    public static void getMaxVal(int wt[], int val[], int W) {
        int tmp[][] = new int[wt.length + 1][W + 1];

        for (int i = 0; i <= wt.length; i++) {
            //we are inserting one extra row at top
            //so all wt and val indexes will be -1
            //do it at last, after setting in logic
            for (int j = 0; j <= W; j++) {
                if (j == 0 || i == 0)
                    tmp[i][j] = 0;
                else if (j < wt[i - 1])
                    tmp[i][j] = tmp[i - 1][j]; //for this we need one top 0 row
                else {
                    System.out.println(j - wt[i - 1]);
                    tmp[i][j] = Math.max(tmp[i - 1][j], val[i - 1] + tmp[i - 1][j - wt[i - 1]]);
                }
            }
        }
        System.out.println(tmp[wt.length][W]);

    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        getMaxVal(wt, val, W);
    }
}
