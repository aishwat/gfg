package com.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class ArticulationPointsGraph {
    //adjacency list representation
    public int V;
    public LinkedList<Integer> adj[];
    int time = 0;

    ArticulationPointsGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void APUtil(int u, boolean visited[], int disc[], int low[], int parent[], boolean ap[]) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        Iterator<Integer> i = adj[u].listIterator();

        while (i.hasNext()) {
            int v = i.next();
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                //while coming out , update low
                low[u] = Math.min(low[u], low[v]);

                //1st condition
                if (parent[u] == -1 && children > 1) {
                    ap[u] = true;
                }
                //2nd cond
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    ap[u] = true;
                }

            } else if (v != parent[u]) { //low can be updated only from childs
                //even if v was visited but can contribute to u's low time
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void AP() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean ap[] = new boolean[V];
        Arrays.fill(parent, -1);
        Arrays.fill(visited, false);
        Arrays.fill(ap, false);

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                APUtil(i, visited, disc, low, parent, ap);

        for (int i = 0; i < V; i++)
            if (ap[i] == true)
                System.out.print(i + " ");
    }

    public static void main(String args[]) {
        // Create graphs given in above diagrams
        System.out.println("Articulation points in first graph ");
        ArticulationPointsGraph g1 = new ArticulationPointsGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.AP();
        System.out.println();

        System.out.println("Articulation points in Second graph");
        ArticulationPointsGraph g2 = new ArticulationPointsGraph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.AP();
        System.out.println();

        System.out.println("Articulation points in Third graph ");
        ArticulationPointsGraph g3 = new ArticulationPointsGraph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.AP();
    }
}

