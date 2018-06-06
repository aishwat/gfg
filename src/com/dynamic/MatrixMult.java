package com.dynamic;

public class MatrixMult {
    public static void getMinMultiplications(int a[]) {
        int temp[][] = new int[a.length][a.length];

        int q = 0;
        for (int l = 2; l < a.length; l++) { //first set l
            for (int i = 0; i < a.length - l; i++) { //then set i -> 0 to last valid index ie.
                int j = i + l; //j to last index
                temp[i][j] = 999;
                for (int k = i + 1; k < j; k++) { //vary k from i to j //excluding i and j
                    q = temp[i][k] + temp[k][j] + (a[i] * a[k] * a[j]);
                    if (q < temp[i][j])
                        temp[i][j] = q;
                }
            }
        }
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a.length; j++) {
//                System.out.printf("%d ", temp[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(temp[0][a.length-1]);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4, 2, 3, 5, 3};
        getMinMultiplications(arr);
    }
}
