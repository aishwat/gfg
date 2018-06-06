package com.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class StronglyConnected {
//    static Graph G;

    public static Graph getTranspose(Graph g) {
        Graph gT = new Graph(g.V);
        for (int v = 0; v < g.V; v++) {
            Iterator<Integer> i = g.adj[v].listIterator();
            while (i.hasNext()) {
                gT.adj[i.next()].add(v);
            }
        }
        return gT;
    }

    public static boolean isSC(Graph g) {
        boolean visited[] = new boolean[g.V];
        Arrays.fill(visited, false);
        DFS(g, 0, visited);
        for (int i = 0; i < g.V; i++) {
            if (!visited[i])
                return false;
        }
        Graph gT = getTranspose(g);
        Arrays.fill(visited, false);
        DFS(gT, 0, visited);
        for (int i = 0; i < g.V; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    public static void DFS(Graph graph, int s, boolean visited[]) { //just have a look but follow recursive
        Stack<Integer> stack = new Stack<Integer>();

        visited[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            int v = stack.peek();
            stack.pop();
            System.out.printf("->%d ", v);

            Iterator<Integer> i = graph.adj[v].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    stack.push(n);
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        if (isSC(g1))
            System.out.println("Yes");
        else
            System.out.println("No");

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        if (isSC(g2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

