package com.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void BFS(Graph G, int s) {
        boolean visited[] = new boolean[G.V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.printf("%d ", s);

            Iterator<Integer> i = G.adj[s].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        BFS(g,2); //o/p: 2 0 3 1
    }
}
