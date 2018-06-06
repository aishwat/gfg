package com.dynamic;

public class LPS {
    public static void getLongestPalindromicSubsequence(char[] c) {
        int tmp[][] = new int[c.length][c.length];
        for (int i = 0; i < c.length; i++) {
            tmp[i][i] = 1;
        }

        for (int l = 2; l <= c.length; l++) { //l=1 means comparing 2 elem
            for (int i = 0; i < c.length - l + 1; i++) { //+1 because < , or <=c.le-l
                int j = i + l - 1;
                if (c[i] == c[j] && l == 2)
                    tmp[i][j] = 2;
                else if (c[i] == c[j])
                    tmp[i][j] = tmp[i + 1][j - 1] + 2;
                else
                    tmp[i][j] = Math.max(tmp[i][j - 1], tmp[i + 1][j]);
            }
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.printf("%d ", tmp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String seq = "agbdba";
        getLongestPalindromicSubsequence(seq.toCharArray());
    }
}
