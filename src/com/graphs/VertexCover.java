package com.graphs;

import java.util.Arrays;
import java.util.Iterator;

public class VertexCover {
    public static void printVertexCover(Graph g){
        boolean visited[] = new boolean[g.V];
        Arrays.fill(visited, false);
        for (int u = 0; u < g.V; u++) {

            if(!visited[u]){
                Iterator<Integer> i = g.adj[u].listIterator();
                while (i.hasNext()){
                    int v = i.next();
                    if(!visited[v]){
                        visited[u]= true;
                        visited[v]=true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < g.V; i++) {
            if(visited[i])
                System.out.printf("%d ",i);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addUEdge(0, 1);
        g.addUEdge(0, 2);
        g.addUEdge(1, 3);
        g.addUEdge(3, 4);
        g.addUEdge(4, 5);
        g.addUEdge(5, 6);

        printVertexCover(g);
    }
}
