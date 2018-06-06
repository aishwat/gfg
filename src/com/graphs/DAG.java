package com.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class DAG {

    static int V = 6;

    static void shortestPath(GraphWeight G, Stack<Integer> stack) {
        int dist[] = new int[V];
        Arrays.fill(dist, 999);

        System.out.println(stack);

        dist[1] = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (dist[u] != 999) {
                Iterator<AdjListNode> i = G.adjList[u].listIterator();

                while (i.hasNext()) {
                    AdjListNode next_node = i.next();
                    int v = next_node.v;
                    if (dist[v] > dist[u] + next_node.weight)
                        dist[v] = dist[u] + next_node.weight;
                }
            }

        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == 999)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        GraphWeight G = new GraphWeight(V);
        G.addEdge(0, 1, 5);
        G.addEdge(0, 2, 3);
        G.addEdge(1, 3, 6);
        G.addEdge(1, 2, 2);
        G.addEdge(2, 4, 4);
        G.addEdge(2, 5, 2);
        G.addEdge(2, 3, 7);
        G.addEdge(3, 5, 1);
        G.addEdge(3, 4, -1);
        G.addEdge(4, 5, -2);
        LongestPath.G = G;
        Stack<Integer> stack = new Stack();
        stack = LongestPath.topologicalSort();
        shortestPath(G, stack);
    }
}
