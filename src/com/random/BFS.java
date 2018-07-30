package com.random;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class BFS {
    public class Graph {
        int v;
        LinkedList<Integer> adjList[];

        Graph(int v) {
            this.v = v;
            adjList = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
    }

    public void bfs(Graph g, int src) {
        LinkedList<Integer> queue = new LinkedList<>();
        Boolean visited[] = new Boolean[g.v];
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            int s = queue.poll();
            System.out.println(s);
            ListIterator<Integer> itr = g.adjList[s].listIterator();
            while (itr.hasNext()) {
                int v = itr.next();
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
    }

    public void dfs(Graph g, Boolean[] visited, int src) {
        visited[src] = true;

        int s = src;
        ListIterator<Integer> itr = g.adjList[s].listIterator();
        while (itr.hasNext()) {
            int v = itr.next();
            if (!visited[v]) {
                dfs(g, visited, v);
            }
        }
    }
}
