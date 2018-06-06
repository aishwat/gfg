package com.dynamic;

class KadaneResult {
    int maxSum;
    int start;
    int end;

    public KadaneResult(int maxSum, int start, int end) {
        this.maxSum = maxSum;
        this.start = start;
        this.end = end;
    }
}
class Result{
    int maxSum;
    int leftBound;
    int rightBound;
    int upBound;
    int lowBound;
    @Override
    public String toString() {
        return "Result [maxSum=" + maxSum + ", leftBound=" + leftBound
                + ", rightBound=" + rightBound + ", upBound=" + upBound
                + ", lowBound=" + lowBound + "]";
    }

}

public class MaxSumRect {
    public static void getMaxSumRect(int[][] a) {

        int rows = a.length;
        int cols = a[0].length;
        int tmp[] = new int[rows];

        Result result = new Result();

        for (int left = 0; left < cols; left++) {
            //reset tmp
            for (int i = 0; i < rows; i++) {
                tmp[i] = 0;
            }
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    tmp[i] += a[i][right];
                }
                KadaneResult kr = kadane(tmp);
                if(kr.maxSum>result.maxSum){
                    result.maxSum = kr.maxSum;
                    result.leftBound = left;
                    result.rightBound = right;
                    result.upBound = kr.start;
                    result.lowBound = kr.end;

                }
            }
        }
        System.out.println(result.toString());
    }


    public static KadaneResult kadane(int arr[]) {
        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar += arr[i];
            if (maxSoFar < 0) {
                maxSoFar = 0;
                currentStart = i + 1;
            }
            if (max < maxSoFar) {
                maxStart = currentStart;
                maxEnd = i;
                max = maxSoFar;
            }
        }
        return new KadaneResult(max, maxStart, maxEnd);
    }

    public static void main(String[] args) {
        int a[][] = new int[][]{
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}};
        getMaxSumRect(a);
    }
}
