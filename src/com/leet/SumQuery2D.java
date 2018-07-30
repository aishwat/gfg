package com.leet;

public class SumQuery2D {
    public static int[][] getAuxMatrix(int[][] input) {
        int row = input.length;
        int col = input[0].length;

        int[][] T = new int[row + 1][col + 1]; //one extra row and col
        //default filled 0
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                T[i][j] = T[i - 1][j] + T[i][j - 1] + input[i - 1][j - 1] - T[i - 1][j - 1];
            }
        }
        return T;
    }

    public static int getSum(int[][] T, int r1, int c1, int r2, int c2) {
        r1++;
        c1++;
        r2++;
        c2++;
        return T[r2][c2] - T[r1 - 1][c2] - T[r2][c1 - 1] + T[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) {
        int[][] input = {{2, 0, -3, 4}, {6, 3, 2, -1}, {5, 4, 7, 3}, {2, -6, 8, 1}};
        int[][] auxMatrix = getAuxMatrix(input);

        int sum = getSum(auxMatrix, 1, 1, 3, 2);
        System.out.printf("%d", sum); //18
    }
}