package com.dynamic;

import com.graphs.StringCircle;

import java.util.Arrays;

public class LCS {
    public static void getLCS(char X[], char Y[]) {
        int L[][] = new int[X.length][Y.length];


        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < Y.length; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i] == Y[j])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Integer.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        System.out.println(L[X.length - 1][Y.length - 1]);
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB"; //6
        String s2 = "GXTXAYB"; //7
        //GTAB

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();

        getLCS(X, Y);

    }
    //  $ A G T
    //$ 0 0 0 0
    //G 0 0 1 1
    //X 0 0 1 1
    //T 0
}
