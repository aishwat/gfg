package com.leet;

public class RegExp {
    private boolean matchRegexRecursive(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];
        T[0][0] = true;
        for (int i = 0; i < text.length + 1; i++)
            T[i][0] = false;
        for (int i = 0; i < pattern.length + 1; i++)
            T[0][i] = false;
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }


        for (int i = 1; i < text.length + 1; i++) {
            for (int j = 1; j < pattern.length + 1; j++) {
                if (text[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    T[i][j] = T[i - 1][j - 1];
                else if (pattern[j - 1] == '*') {
                    T[i][j] = T[i][j - 2]; //0 occurrence
                    if (text[i - 1] == pattern[j - 2] || pattern[j - 2] == '.') //1 or more occurrence
                        T[i][j] = T[i][j] || T[i - 1][j];
                }
                else{
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];

    }

    public static void main(String[] args) {
        RegExp rm = new RegExp();
        System.out.println(rm.matchRegexRecursive("Tushar".toCharArray(),"Tushar".toCharArray()));
        System.out.println(rm.matchRegexRecursive("Tusha".toCharArray(),"Tushar*a*b*".toCharArray()));
        System.out.println(rm.matchRegexRecursive("".toCharArray(),"a*b*".toCharArray()));
        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),"a*ab*bbbbc*".toCharArray()));
        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),"aa*bbb*bbbc*".toCharArray()));
        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),".*bcc".toCharArray()));
        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
        System.out.println(rm.matchRegexRecursive("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
        System.out.println(rm.matchRegexRecursive("aaa".toCharArray(),"ab*a*c*a".toCharArray()));

        System.out.println(rm.matchRegexRecursive("aa".toCharArray(), "a*".toCharArray()));
    }
}
