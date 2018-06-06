package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
    static class qNode {
        int v;
        int dist;
    }

    public static int getMinDiceThrows(int[] moves, int n) {
        int visited[] = new int[n];
        Queue<qNode> queue = new LinkedList<>();
        qNode uNode = new qNode();
        uNode.v = 0;
        uNode.dist = 0;

        visited[0] = -1;
        queue.add(uNode);

        while (!queue.isEmpty()) {
            uNode = queue.poll();
            int u = uNode.v;

            if (u == n - 1)
                break;
            for (int i = u + 1; i <= u + 6 && i < n; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    qNode vNode = new qNode();
                    vNode.dist = uNode.dist + 1;

                    if (moves[i] != -1)
                        vNode.v = moves[i];
                    else
                        vNode.v = i;
                    queue.add(vNode);
                }
            }
        }
        return uNode.dist; //at end of above while uNode pointed to last vertex
    }

    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));
    }
}
