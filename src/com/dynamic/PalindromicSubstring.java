package com.dynamic;

//Manacher if time
public class PalindromicSubstring {
    public static void getLongestPalindromicSubStr(char[] ch) {
        boolean T[][] = new boolean[ch.length][ch.length];
        for (int i = 0; i < ch.length; i++) {
            T[i][i] = true;
        }
        int max_len = 0;
        for (int l = 1; l < ch.length; l++) {
            for (int i = 0; i < ch.length - l; i++) {
                int j = i + l;
                if (ch[i] == ch[j] && l == 1) {
                    T[i][j] = true;
                    max_len = 1;
                } else if (ch[i] == ch[j] && T[i + 1][j - 1]) {
                    T[i][j] = true;
                    max_len = l;
                } else
                    T[i][j] = false;
            }
        }
        print_arr(T);
        System.out.printf("\n%d", max_len + 1);
    }

    public static void print_arr(boolean arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%s\t", arr[i][j] ? 'T' : 'F');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        getLongestPalindromicSubStr(str.toCharArray());
    }
}
