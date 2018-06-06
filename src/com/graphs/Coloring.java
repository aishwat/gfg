package com.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Coloring {
    int V;
    LinkedList<Integer> adj[];

    Coloring(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    void greedyColoring() {
        int result[] = new int[V];
        boolean available[] = new boolean[V];
        Arrays.fill(result, -1);
        Arrays.fill(available, true);

        result[0] = 0;
        for (int u = 0; u < V; u++) {
            //for each u
            //first traverse adj list and mark their colors unavailable
            //then find first available color
            //assign that to this u
            //reset available color
            Iterator<Integer> i = adj[u].listIterator();
            while (i.hasNext()) {
                int v = i.next();
                //if adjacent node already has a color set that color as unavailable
                if (result[v] != -1) {
                    available[result[v]]=false;
                }
            }
            int color;
            for (color= 0; color < V; color++) {
                if(available[color])
                    break;
            }
            result[u] = color;
            Arrays.fill(available, true);
        }
        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " --->  Color "
                    + result[u]);

    }

    public static void main(String[] args) {
        Coloring g1 = new Coloring(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();

        System.out.println();
        Coloring g2 = new Coloring(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of graph 2 ");
        g2.greedyColoring();
    }
}
