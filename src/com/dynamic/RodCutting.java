package com.dynamic;

public class RodCutting {
    public static void getMaxPrice(int[] a) {
        int tmp[][] = new int[a.length][a.length + 1];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= a.length; j++) {
                if (j == 0)
                    tmp[i][j] = 0;
                else if (i == 0)
                    tmp[i][j] = j;
                else if (j < i+1)
                    tmp[i][j] = tmp[i - 1][j];
                else
                    tmp[i][j] = Math.max(tmp[i - 1][j], a[i] + tmp[i][j - (i+1)]); //i is the len
                    //need to balance index
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= a.length; j++) {
                System.out.printf("%d ", tmp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        getMaxPrice(arr);
    }
}
