package com.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class LongestPath {
    static GraphWeight G;

    public static void topologicalSortUtil(int v, boolean visited[], Stack stack) {
        visited[v] = true;

        Iterator<AdjListNode> i = G.adjList[v].listIterator();

        while (i.hasNext()) {
            AdjListNode n = i.next();

            if (!visited[n.v]) {
                topologicalSortUtil(n.v, visited, stack);
            }
        }
        stack.push(v);
    }

    public static Stack topologicalSort() {
        boolean visited[] = new boolean[G.V];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackReturn = new Stack<>();

        for (int i = 0; i < G.V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        stackReturn.addAll(stack);


        int dist[] = new int[G.V];
        Arrays.fill(dist, -999);
        dist[1] = 0;


        while (!stack.isEmpty()) {
            int u = stack.pop();
//            System.out.printf("\npopped: %d", u);
            Iterator<AdjListNode> i = G.adjList[u].listIterator();
            
//                System.out.printf("\nprocessing %d", u);
                while (i.hasNext()) { //put longest for all neighbours
                    AdjListNode n = i.next();
//                    System.out.printf("\n__processing %d", n.v);
                    if (dist[n.v] < dist[u] + n.weight){
                        dist[n.v] = dist[u] + n.weight; //put to max

                    }
                }
        }
        System.out.println(Arrays.toString(dist));
//        System.out.println(stackReturn);
        return stackReturn;
    }

    public static void main(String[] args) {
        G = new GraphWeight(6);
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
        topologicalSort();
    }
}
