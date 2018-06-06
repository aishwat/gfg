package com.graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    //adjacency list representation
    public int V;
    public LinkedList<Integer> adj[];
    int[] inDegree;

    Graph(int v){
        V=v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }

        inDegree = new int[v];
        Arrays.fill(inDegree, 0);
    }
    void addEdge(int v, int w){
        adj[v].add(w);
        inDegree[v]++;
    }
    void addUEdge(int v, int w){ //undirected
        adj[v].add(w);
        adj[w].add(v);
    }
}
