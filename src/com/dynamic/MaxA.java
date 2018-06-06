package com.dynamic;

public class MaxA {
    public static void getMaxA(int k) {
        //0=> A => 1 key => same o/p
        //1=> CA,CC,CV => 3keys => 2*Selection
        //2=> CA,CC,CV,CV => 4keys => 3*Selection
        //3 => test cv,cv,cv
        int T[][] = new int[4][k + 1];

        for (int j = 0; j <= k; j++) { //processing one column at a time
            for (int i = 0; i < 4; i++) { //then top to down in row
                if (i == 0)
                    T[i][j] = j;
                else if (j <= 4)
                    T[i][j] = j;
                else if (j > 4 && i == 1) {
                    int maxFor1 = getMax(T[1][j - 3], T[2][j - 3], T[3][j - 3]); //at back 3 column, see which was max in buffer//use that for CA,CC,CV
                    T[i][j] = Math.max(T[0][j], maxFor1 * 2); //to handle till 6 cases
                }
                else if (j > 4 && i == 2) {
                    int maxFor2 = getMax(T[1][j - 4], T[2][j - 4], T[3][j - 4]); //go back 4 columns
                    T[i][j] = Math.max(T[0][j], maxFor2 * 3);
                }
                else if (j > 4 && i == 3) {
                    int maxFor2 = getMax(T[1][j - 5], T[2][j - 5], T[3][j - 5]); //go back 5 columns
                    T[i][j] = Math.max(T[0][j], maxFor2 * 4);
                }
            }
        }
        print_arr(T);
    }

    public static int getMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static void print_arr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        getMaxA(20);
    }
}
