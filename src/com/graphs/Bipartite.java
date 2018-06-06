package com.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    static Graph g;

    public static boolean BFSUtil(int s, int[] color, LinkedList<Integer> queue) {
        color[s] = 0;
        queue.push(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int otherColor = color[u] == 0 ? 1 : 0;
//            System.out.printf("%d ", u);

            Iterator<Integer> i = g.adj[u].listIterator();

            while (i.hasNext()) {
                int v = i.next();

                if (color[v] == -1) {
                    color[v] = otherColor;
                    queue.add(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void BFS() {
        int color[] = new int[g.V];
        Arrays.fill(color, -1);
        LinkedList<Integer> queue = new LinkedList<>();


        for (int i = 0; i < g.V; i++) {
            if (color[i] == -1) {
                if (!BFSUtil(i, color, queue)) {
                    System.out.println("not bipartite");
                    return;
                }
            }
        }
        System.out.println("bipartite");
    }

    public static void main(String[] args) {
        g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 2);

        BFS(); //o/p: 2 0 3 1
    }
}
