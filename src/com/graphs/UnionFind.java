package com.graphs;

public class UnionFind {
    static int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    static boolean hasCycle(GraphUndirected G) {
        int parent[] = new int[G.V];
        for (int i = 0; i < G.V; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < G.E; i++) {
            int x = find(parent, G.edge[i].src);
            int y = find(parent, G.edge[i].dest);
            if (x == y)
                return true;
            else
                union(parent, x, y);
        }
        return false;
    }

    public static void main(String[] args) {
        /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
        int V = 3, E = 3;
        GraphUndirected graph = new GraphUndirected(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (hasCycle(graph))
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }
}

