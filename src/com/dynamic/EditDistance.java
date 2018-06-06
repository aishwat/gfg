package com.dynamic;

public class EditDistance {
    public static void editDist(String s1, String s2) {
        System.out.println("s1: " + s1.length() + "\ns2: " + s2.length());
        int[][] L = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            L[i][0] = i;
        }
        for (int i = 0; i < s2.length(); i++) {
            L[0][i] = i;
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j))
                    L[i][j] = L[i - 1][j - 1];
                else
                    L[i][j] = min(L[i - 1][j], L[i - 1][j - 1], L[i][j - 1]) + 1;
            }
        }
        System.out.println(L[s1.length()-1][s2.length()-1]);
        print_arr(L);
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void print_arr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";

        editDist(str1, str2);
    }
}
