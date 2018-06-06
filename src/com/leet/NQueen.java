package com.leet;

import java.util.Arrays;

public class NQueen {
    static class Position {
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Position[] solveNQueen(int n) {
        Position[] positions = new Position[n];
        boolean hasSol = solveNQueenUtil(n, 0, positions);
        if (hasSol)
            return positions;
        else
            return new Position[0];
    }

    private boolean solveNQueenUtil(int n, int row, Position[] positions) {
        if (row == n) return true;

        for (int col = 0; col < n; col++) {
            boolean foundSafe = checkIsSafe(row, col, positions);

            if (foundSafe) {
                positions[row] = new Position(row, col);
                //recur
                if (solveNQueenUtil(n, row + 1, positions))
                    return true;
            }
        }
        return false;
    }

    private boolean checkIsSafe(int row, int col, Position[] positions) {
        for (int queen = 0; queen < row; queen++) {
            if (positions[queen].col == col ||
                    positions[queen].row == row ||
                    positions[queen].row - positions[queen].col == row - col ||
                    positions[queen].row + positions[queen].col == row + col){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen s = new NQueen();
        Position[] positions = s.solveNQueen(6);
        Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
    }
}
