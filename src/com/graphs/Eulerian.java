package com.graphs;

public class Eulerian {
    public static boolean isConnected(Graph g) {
        DFS.G = g;
        boolean[] visited = new boolean[g.V];
        int i;
        for (i = 0; i < g.V; i++) {
            if (g.adj[i].size() != 0)
                break;
        }
        if (i == g.V)
            return true; //no edges

        DFS.DFSUtil(i, visited);
        for (int j = 0; j < g.V; j++) {
            if (!visited[j])
                return false;
        }
        return true;
    }

    public static int isEulerian(Graph g) {
        if (!isConnected(g))
            return 0;

        int odd = 0;
        for (int i = 0; i < g.V; i++) {
            if (g.adj[i].size() % 2 != 0)
                odd++;
        }
//        if (odd > 2)
//            return 0;

        if (odd == 2) //eulerian path
            return 1;
        if (odd == 0) //eulerian circuit
            return 2;
        return 0;
    }

    public static void test(Graph g) {
        int res = isEulerian(g);
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has a Euler path");
        else
            System.out.println("graph has a Euler cycle");
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addUEdge(1, 0);
        g1.addUEdge(0, 2);
        g1.addUEdge(2, 1);
        g1.addUEdge(0, 3);
        g1.addUEdge(3, 4);
        test(g1);
    }
}
