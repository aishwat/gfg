package com.graphs;

import java.util.LinkedList;

public class GraphWeight {
    public int V;
    public LinkedList<AdjListNode> adjList[]; //array of linked lists

    GraphWeight(int v) {
        V = v;
        adjList = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<AdjListNode>();
        }
    }

    void addEdge(int u, int v, int w) {
        AdjListNode node = new AdjListNode(v, w);
        adjList[u].add(node);
    }
}

class AdjListNode {
    public int v, weight;

    AdjListNode(int _v, int w) {
        v = _v;
        weight = w;
    }
}
