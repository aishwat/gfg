package com.graphs;

import java.util.Iterator;

public class DFSCycle {
    static Graph g;

    //For directed graph we need recStack
    public static boolean hasCycleUtil(int v, boolean[] visited, boolean[] recStack) {
        //if visited and in recStack => hasCycle
        if (!visited[v]) {
            visited[v] = true;
            recStack[v] = true;

            Iterator<Integer> i = g.adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next(); //neighbour
                if (!visited[n] && hasCycleUtil(n, visited, recStack)) { //if not visited then only call recursive hasCycleUtil
                    return true;    //if hasCycleUtil returned true , return true here
                } else if (recStack[n]) {
                    return true; //if in rec stack, return true
                }
            }
        }
        recStack[v] = false;
        return false;
    }

    //For undirected we need parent
    public static boolean hasCycleUtilUndirected(int v, boolean[] visited, int parent) {
        visited[v] = true;
        Iterator<Integer> i = g.adj[v].listIterator();

        //if next vertex is not parent and is visited => cycle
        while (i.hasNext()) {
            int n = i.next();

            if (!visited[n]) {
                if (hasCycleUtilUndirected(n, visited, v))
                    return true;
            } else if (n != parent) { //visited and n not parent
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        g = new Graph(6);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
//        boolean[] visited = new boolean[g.V];
//        boolean[] recStack = new boolean[g.V];
//        System.out.printf("\nhas cycle: %b", hasCycleUtil(s, visited, recStack));

//        g = new Graph(5);
//        g.addEdge(1, 0);
//        g.addEdge(0, 2);
//        g.addEdge(2, 0);
//        g.addEdge(0, 3);
//        g.addEdge(3, 4);
//        boolean[] visited = new boolean[g.V];
//
//        if (hasCycleUtilUndirected(0, visited, -1))
//            System.out.println("Graph contains cycle");
//        else
//            System.out.println("Graph doesn't contains cycle");

        g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        boolean[] visited = new boolean[g.V];
        if (hasCycleUtilUndirected(0, visited, -1))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

    }
}
