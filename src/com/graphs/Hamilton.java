package com.graphs;

import java.util.Arrays;

public class Hamilton {
    static int V = 5;
    int path[];

    boolean isSafe(int v, int g[][], int path[], int pos) {
        if (g[path[pos - 1]][v] == 0)
            return false;
        for (int i = 0; i < V; i++) {
            if (path[i] == v)
                return false;
        }
        return true;
    }

    boolean hamCycleUtil(int g[][], int path[], int pos) {
        if (pos == V) {
            if (g[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, g, path, pos)) {
                path[pos] = v;
                // then recur
                if (hamCycleUtil(g, path, pos + 1))
                    return true;

                //if reaches here then hamCycle returned false
                //reset path[pos] and next combination vl be tried
                path[pos] = -1;
            }
        }
        //shouldnt reach here if cycle
        return false;
    }

    boolean hamCycle(int g[][]) {
        path = new int[V];
        Arrays.fill(path, -1);
        path[0]=0;

        if (hamCycleUtil(g, path, 1) == false) {
            System.out.println("\nSolution does not exist");
            return false;
        }
        printSolution(path);
        return true;
    }

    void printSolution(int path[]) {
        System.out.println("Solution Exists: Following" +
                " is one Hamiltonian Cycle");
        for (int i = 0; i < V; i++)
            System.out.print(" " + path[i] + " ");

        // Let us print the first vertex again to show the
        // complete cycle
        System.out.println(" " + path[0] + " ");
    }

    public static void main(String[] args) {
        Hamilton hamiltonian =
                new Hamilton();
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int graph1[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        // Print the solution
        hamiltonian.hamCycle(graph1);

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };

        // Print the solution
        hamiltonian.hamCycle(graph2);
    }
}

