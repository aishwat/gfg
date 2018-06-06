package com.graphs;

import java.util.Arrays;

public class BellmanFord {
    static GraphUndirected graph;

    public static void bellmanFord(int src) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];
        Arrays.fill(dist, 9999);
        dist[src] = 0;

        //rem for loop structure , for v-1 times relax all edges
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int w = graph.edge[j].weight;
                if (dist[v] > dist[u] + w && dist[u] != 999) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        for (int i = 0; i < E; i++) {
            int u = graph.edge[i].src;
            int v = graph.edge[i].dest;
            int w = graph.edge[i].weight;
            if (dist[v] > dist[u] + w && dist[u] != 999) {
                System.out.println("negative weight cycle");
            }
        }
        printArr(dist, V);

    }

    static void printArr(int dist[], int V) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;  // Number of vertices in graph
        int E = 8;  // Number of edges in graph

        graph = new GraphUndirected(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        bellmanFord(0);
    }
}
