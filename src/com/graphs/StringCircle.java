package com.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class StringCircle {

    public static void DFSUtil(Graph g, int v, boolean[] visited) {
        visited[v] = true;
        System.out.printf("->%d", v);
        Iterator<Integer> i = g.adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(g, n, visited);
            }
        }
    }

    public static Graph getTranspose(Graph g) {
        Graph gT = new Graph(g.V);

        for (int u = 0; u < g.V; u++) {
            Iterator<Integer> i = g.adj[u].listIterator();
            while (i.hasNext()) {
                int v = i.next();
                gT.addEdge(v, u);
            }
        }
        return gT;
    }

    public static boolean isSC(Graph g) {
        boolean visited[] = new boolean[g.V];
        Arrays.fill(visited, false);

        int s;
        for (s = 0; s < g.V; s++)
            if (g.adj[s].size() > 0)
                break;
        DFSUtil(g, s, visited);

        for (int i = 0; i < g.V; i++) {
            if (g.adj[i].size() > 0 && !visited[i])
                return false;
        }

        Graph gT = getTranspose(g);
        Arrays.fill(visited, false);

        for (s = 0; s < g.V; s++)
            if (gT.adj[s].size() > 0)
                break;
        DFSUtil(gT, s, visited);
        for (int i = 0; i < g.V; i++) {
            if (gT.adj[i].size() > 0 && !visited[i])
                return false;
        }

        return true;
    }

    public static boolean isEulerianCycle(Graph g) {
        if (!isSC(g))
            return false;
        for (int i = 0; i < g.V; i++) {
            if (g.adj[i].size() != g.inDegree[i])
                return false;
        }
        return true;
    }

    public static boolean canBeChained(String arr[], int n) {
        Graph g = new Graph(26);
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            int u = s.charAt(0) - 'a';
            int v = s.charAt(s.length() - 1) - 'a';
            System.out.println(u + "\t" + v);
            g.addEdge(u, v);
        }
        return isEulerianCycle(g);
    }

    public static void main(String[] args) {
        StringCircle graph = new StringCircle();
        String arr1[] = {"for", "geek", "rig", "kaf"};
        int n1 = arr1.length;
        System.out.println("\n"+canBeChained(arr1, n1));


        String arr2[] = {"aab", "abb"};
        int n2 = arr2.length;
        System.out.println("\n"+canBeChained(arr2, n2));

    }
}
