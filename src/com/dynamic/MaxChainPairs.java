package com.dynamic;

import java.util.Arrays;

class Pair implements Comparable<Pair> {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair o) {
        return this.a - o.a;
    }
}

public class MaxChainPairs {
    public static void getMaxLenChainOfPairs(Pair[] pairs) {
        Arrays.sort(pairs);
        int tmp[] = new int[pairs.length];
        Arrays.fill(tmp, 1);

        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j].b < pairs[i].a && tmp[i] < tmp[j] + 1)
                    tmp[i] = tmp[j] + 1;
            }
        }
        System.out.println(Arrays.toString(tmp)); //get max and return
    }

    public static void main(String[] args) {
        Pair arr[] = new Pair[]{new Pair(5, 24), new Pair(15, 25),
                new Pair(27, 40), new Pair(50, 60)};
        getMaxLenChainOfPairs(arr);
    }
}
