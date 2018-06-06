package com.dynamic;

public class SubsetSum {
    public static void hasSubsetSum(int a[], int n) {
        boolean T[][] = new boolean[a.length][n + 1];

        //handle 1st row sep
        for (int j = 0; j < n + 1; j++) {
            if (a[0] == j)
                T[0][j] = true;
        }
        //handle 1st col
        for (int i = 0; i < a.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < a[i])
                    T[i][j] = T[i - 1][j];
                else
                    T[i][j] = T[i - 1][j] || T[i - 1][j - a[i]];
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%s ", T[i][j]?'T':'F');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 8, 10};
        int k = 11;
        hasSubsetSum(arr, k);
    }
}
