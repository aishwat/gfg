package com.dynamic;

public class MaxProfitShares {
    public static void getMaxProfit(int price[], int k) {
        int T[][] = new int[k + 1][price.length];
        //2 cases either no transaction on day j
        //do transaction on jth day and see for (buying day) m-> 0 to j-1 which gives max profit
        //base case of 0 filled row col by default
        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < price.length; j++) {
                int no_trx = T[i][j - 1];
                int yes_trx = -99;
                for (int m = 0; m < j; m++) {
                    yes_trx = Math.max(yes_trx, (price[j] - price[m]) + T[i - 1][m]);//plus the i-1 left trx , which we could have done till m
                }
                T[i][j] = Math.max(no_trx, yes_trx);
            }
        }
        print_arr(T);
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
        int arr[] = {2, 5, 7, 1, 4, 3, 1, 3};
        getMaxProfit(arr, 3); //on max 3 transcations
    }
}
