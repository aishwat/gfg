package com.graphs;

import java.util.Iterator;
import java.util.Stack;

public class Topological {
    static Graph g;

    public static void topologicalSortUtil(int v, boolean visited[], Stack stack) {
        visited[v] = true;
        Iterator<Integer> i = g.adj[v].listIterator();

        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                topologicalSortUtil(n, visited, stack);
            }
        }
        stack.push(v);
    }

    public static void topologicalSort() {
        boolean[] visited = new boolean[g.V];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < g.V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        while (!stack.isEmpty()) {
            System.out.printf("->%d", stack.pop());
        }

    }

    public static void main(String[] args) {
        g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        topologicalSort();
    }
}
