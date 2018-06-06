package com.dynamic;

public class LSumContSubArr {
    public static void getLargestContiguousSumSubArray(int[] a) {
        int max_ending_here = 0, max_so_far = 0;
        for (int i = 0; i < a.length; i++) {
            max_ending_here = max_ending_here + a[i];

            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

            if (max_ending_here < 0)
                max_ending_here = 0;
            System.out.printf("%d ",max_ending_here);
        }
        System.out.println("\n"+max_so_far);
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        getLargestContiguousSumSubArray(a);
    }
}
