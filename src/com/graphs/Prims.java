package com.graphs;

import java.util.Arrays;

public class Prims {
    private static final int V = 5;

    public static int minKey(int key[], boolean mstSet[]) {
        int minIndex = -1;
        int min = 999;
        for (int i = 0; i < V; i++) {
            if (key[i] < min && !mstSet[i]) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void primMST(int g[][]) {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean mstSet[] = new boolean[V];

        Arrays.fill(parent, -1);
        Arrays.fill(key, 9999);
        Arrays.fill(mstSet, false);

        key[0] = 0;

        for (int i = 0; i < V; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (g[u][v] != 0 && !mstSet[v] && g[u][v] < key[v]) {
                    key[v] = g[u][v];
                    parent[v] = u;
                }
            }
        }
        printMST(parent, g);
    }

    public static void printMST(int[] parent, int[][] g) {
        System.out.println("Edge   Weight");
        //remember original weights never changed, just what edges, we need
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + "-" + i + "   " + g[i][parent[i]]);
        }

    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        // Print the solution
        primMST(graph);
    }
}
