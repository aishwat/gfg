package com.dynamic;

public class OptimalBSTree {
    public static void getOptimalBinarySearchTree(int[] keys, int[] freq) {
        int T[][] = new int[keys.length][keys.length];
        for (int i = 0; i < keys.length; i++) {
            T[i][i] = freq[i];
        }
        int sum = 0;
        for (int l = 1; l < keys.length; l++) {
            for (int i = 0; i < keys.length - l; i++) {
                int j = i + l;
                T[i][j] = 999;
                for (int k = i; k <= j; k++) {
                    sum = getSum(freq, i, j);
                    int val = 0;
                    if (k == i)
                        val = sum + T[k + 1][j];
                    else if (k == j)
                        val = sum + T[i][k - 1];
                    else
                        val = sum + T[i][k - 1] + T[k + 1][j];
                    if (val < T[i][j])
                        T[i][j] = val;
                }
            }
        }
        print_arr(T);
        System.out.println(T[0][keys.length - 1]);
    }

    public static void print_arr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int getSum(int[] freq, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int keys[] = {10, 12, 16, 21};
        int freq[] = {4, 2, 6, 3};
        getOptimalBinarySearchTree(keys, freq);
    }
}
