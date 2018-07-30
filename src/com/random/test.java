package com.random;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void findTeams(int[] players, int[] ids, int _k) {
        int n = players.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (players[j] < players[i])
                    swap(players, ids, i, j);
            }
        }
        System.out.println(Arrays.toString(players));
        int min = 0;
        int max = n-1;
        ArrayList<Integer> Alist = new ArrayList<>();
        ArrayList<Integer> Blist = new ArrayList<>();
        for (int k = 1; k <= _k; k++) {
            if (k % 2 == 0) {
                Alist.add(players[min]);
                Blist.add(players[min+1]);
            } else {
                Alist.add(players[max]);
                Blist.add(players[max-1]);
            }
        }
        System.out.println(Arrays.toString(Alist.toArray()));
        System.out.println(Arrays.toString(Blist.toArray()));

    }

    public static void swap(int[] a, int[] b, int i, int j) {
        int tmp1 = a[i];
        int tmp2 = b[i];
        a[i] = a[j];
        b[i] = b[j];
        a[j] = tmp1;
        b[j] = tmp2;
    }

    public static void main(String[] args) {
        int[] players = {4, 4, 2, 2, 5,6};
        int[] ids = {1, 2, 3, 4, 5,6};
        findTeams(players, ids, 3);
    }
}
