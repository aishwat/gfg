package com.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stairs {
    public static void getWaysCount(int s, int m) {
        int res[] = new int[s];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < s; i++) {
            res[i] = 0;
            //ith stair can be reached from i-1, i-2, ... i-m
            for (int j = 1; j <= m && j <= i; j++) { //j cant go above i
                res[i] += res[i - j];
            }
        }
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        int s = 4, m = 2;
        getWaysCount(s, m);
    }
}
