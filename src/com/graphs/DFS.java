package com.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class DFS {

    static Graph G;

    public static void DFS(int s) { //just have a look but follow recursive
        boolean visited[] = new boolean[G.V];
        Stack<Integer> stack = new Stack<Integer>();

        visited[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            int v = stack.peek();
            stack.pop();
            System.out.printf("->%d ", v);

            Iterator<Integer> i = G.adj[v].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    stack.push(n);
                }
            }
        }

    }
    public static void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.printf("->%d", v);
        Iterator<Integer> i = G.adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public static void DFS_Rec(int s) {
        boolean[] visited = new boolean[G.V];
        DFSUtil(s, visited);
    }

    public static void main(String[] args) {

        G = new Graph(7);
        G.addEdge(0,1);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(2,0);
        G.addEdge(0,4);
        G.addEdge(4,5);
        G.addEdge(5,6);
        G.addEdge(5,2);
        DFS(0); //o/p: 0 3 2 1 4
        System.out.println();
        G = new Graph(6);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 2);
        G.addEdge(2, 0);
        G.addEdge(2, 3);
        G.addEdge(3, 3);
        DFS_Rec(0); //o/p: 0 3 2 1 4
    }
}
