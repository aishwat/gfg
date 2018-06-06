package com.dynamic;

public class PalindromePartitioning {
    public static void getMinPartitions(char[] ch) {
        int tmp[][] = new int[ch.length][ch.length];

        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == ch[i + 1])
                tmp[i][i + 1] = 0;
            else
                tmp[i][i + 1] = 1;
        }
        for (int l = 2; l < ch.length; l++) {
            for (int i = 0; i < ch.length - l; i++) {
                int j = i + l;
                tmp[i][j] = 99;
                if (ch[i] == ch[j])
                    tmp[i][j] = tmp[i + 1][j - 1];
                else {
                    for (int k = i; k < j; k++) { //varying k from i to j, i inclusive , j exclusive, unlike mat mult where both exclusive
                        tmp[i][j] = Math.min(tmp[i][j], 1 + tmp[i][k] + tmp[k + 1][j]);
                    }
                }
            }
        }
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                System.out.printf("%d ", tmp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        getMinPartitions(str.toCharArray());
    }
}
