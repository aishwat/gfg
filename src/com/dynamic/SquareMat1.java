package com.dynamic;

public class SquareMat1 {
    public static void printMaxSubSquare(int M[][]) {
        int S[][] = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++)
            S[i][0] = M[i][0];
        for (int j = 0; j < M[0].length; j++)
            S[0][j] = M[0][j];


        for (int i = 1; i < S.length; i++) {
            for (int j = 1; j < S[0].length; j++) {
                if (M[i][j] == 1) {
                    S[i][j] = min(S[i - 1][j], S[i][j - 1], S[i - 1][j - 1]) + 1;
                }
            }
        }
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S[0].length; j++) {
                System.out.printf("%d ", S[i][j]);
            }
            System.out.println();
        }
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        printMaxSubSquare(M);
    }
}
