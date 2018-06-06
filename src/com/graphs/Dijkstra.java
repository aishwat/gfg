package com.graphs;

import java.util.Arrays;

public class Dijkstra {
    static final int V = 9;

    int minDistance(int dist[], boolean[] sptSet) {
        int min = 999;
        int minIndex = -1;
        for (int i = 0; i < V; i++) {
            if (!sptSet[i] && dist[i] < min) {
                minIndex = i;
                min = dist[i];
            }
        }
        return minIndex;
    }

    void dijkstra(int g[][], int src) {
        int dist[] = new int[V];
        boolean sptSet[] = new boolean[V];
        int parent[] = new int[V];
        Arrays.fill(dist, 999);
        Arrays.fill(sptSet, false);
        Arrays.fill(parent, -1);

        dist[src] = 0;
        for (int i = 0; i < V; i++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && g[u][v] != 0 && dist[u] != 999 && dist[v] > dist[u] + g[u][v]) {
                    dist[v] = dist[u] + g[u][v];
                    parent[v] = u;
                }
            }
        }
        printSolution(dist, V);
    }
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        new Dijkstra().dijkstra(graph, 0);
    }
}
