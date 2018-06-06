package com.dynamic;

public class WordWrap {
    public static int square(int a) {
        Double tmp = Math.pow(a, 2);
        return tmp.intValue();
    }

    //also gives result O(n^3)
    public static void getLineBreaks(int[] a, int n) {
        int T[][] = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            T[i][i] = square(n - a[i]);
        }

        for (int l = 1; l < a.length; l++) {
            for (int i = 0; i < a.length - l; i++) {
                int j = i + l;
                T[i][j] = Integer.MAX_VALUE;

                int len = getTotalLen(a, i, j);
                if (len <= n)
                    T[i][j] = square(n - len);

                for (int k = i; k < j; k++) {
                    if (T[i][j] > T[i][k] + T[k + 1][j]) {
                        T[i][j] = T[i][k] + T[k + 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%d\t", T[i][j]);
            }
            System.out.println();
        }
    }

    public static int getTotalLen(int a[], int i, int j) {
        int sum = a[i];
        for (int k = i + 1; k <= j; k++) {
            sum = sum + a[k] + 1;
        }
        return sum;
    }

    //actual// O(n^2)
    static int MAX = 999;

    public static int[][] getCost(int[] a, int n) {
        int cost[][] = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            cost[i][i] = square(n - a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                cost[i][j] = MAX;
                int len = getTotalLen(a, i, j);

                if (len <= n)
                    cost[i][j] = square(n - len);
                else
                    cost[i][j] = MAX;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%d\t", cost[i][j]);
            }
            System.out.println();
        }
        return cost;
    }

    public static void getMinCost(int[][] cost, int[] a) {
        int minCost[] = new int[a.length];
        int res[] = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            minCost[i] = cost[i][a.length - 1];
            res[i] = a.length; //+1 of ending
            for (int j = a.length - 1; j > i; j--) {
                if (cost[i][j - 1] == MAX)
                    continue;
                if (minCost[i] > minCost[j] + cost[i][j - 1]) {
                    minCost[i] = minCost[j] + cost[i][j - 1];
                    res[i] = j;
                }

            }
        }
        //copied part
        int i = 0;
        int j;

        System.out.println("Minimum cost is " + minCost[0]);
        System.out.println("\n");
        //finally put all words with new line added in
        //string buffer and print it.
        StringBuilder builder = new StringBuilder();
        do {
            j = res[i];
            for (int k = i; k < j; k++) {
                builder.append(a[k] + " ");
            }
            builder.append("\n");
            i = j;
        } while (j < a.length);

        System.out.println(builder.toString());

    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 5, 2, 4}; //tushar roy likes to code
        int k = 10; //line width
        getLineBreaks(arr, k);
        int cost[][] = getCost(arr, k);
//        getMinCost(cost, arr);
    }
}
