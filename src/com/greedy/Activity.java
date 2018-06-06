package com.greedy;

public class Activity {
    public static void printMaxActivities(int[] s, int[] f) {

        //1st is picked
        int picked = 0;
        System.out.println(s[0] + "-" + f[0]);

        for (int i = 1; i < s.length; i++) {
            if (s[i] >= f[picked]) {
                picked = i;
                System.out.println(s[i] + "-" + f[i]);
            }
        }
    }

    public static void main(String[] args) {
        int s[] = {1, 3, 0, 5, 8, 5};
        int f[] = {2, 4, 6, 7, 9, 9}; //assume sorted

        printMaxActivities(s, f);
    }
}
