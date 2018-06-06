package com.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinCostDestTrain {
    static int INF = 999;

    public static void getMinCost(int cost[][]) {
        //think from last to 1st
        //min[i] is min cost from i to dest ,, loop on j to get via
        int dest = cost.length - 1;
        int min[] = new int[cost.length];
        min[dest] = 0;

        for (int i = dest - 1; i >= 0; i--) {
            min[i] = cost[i][dest];

            for (int j = i + 1; j < dest; j++) {
                min[i] = Math.min(min[i], cost[i][j] + min[j]);
            }
        }
        System.out.println(Arrays.toString(min));
    }

    public static void main(String[] args) {
        int cost[][] = {{0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
        };
        getMinCost(cost);
    }
}
