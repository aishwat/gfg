package com.graphs;

import java.util.Arrays;

public class Kruskals {
    int V, E;
    Edge edge[];

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }


    Kruskals(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskalMST() {
        Edge result[] = new Edge[V];
        for (int i = 0; i < V; i++) {
            result[i] = new Edge();
        }

        Arrays.sort(edge);
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        int e = 0, i = 0;

        while (e < V - 1) {
            Edge next_edge = new Edge();
            next_edge = edge[i];

            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result[e] = next_edge;
                union(parent, x, y);
                e++;
            }
            i++;
        }

        System.out.println("Following are the edges in " +
                "the constructed MST");

        for (int j = 0; j < V-1; ++j) {
            System.out.println(result[j].src + " -- " +
                    result[j].dest + " == " + result[j].weight);
        }

    }

    public static void main(String[] args) {
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Kruskals graph = new Kruskals(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.kruskalMST();
    }
}
