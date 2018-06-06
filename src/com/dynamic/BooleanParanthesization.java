package com.dynamic;

public class BooleanParanthesization {
    public static void getParanthesis(char[] symbols, char[] oper) {
        int n = symbols.length;
        int T[][] = new int[n][n];
        int F[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            T[i][i] = symbols[i] == 'T' ? 1 : 0;
            F[i][i] = symbols[i] == 'F' ? 1 : 0;
        }
        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = i + l;
                for (int k = i; k < j; k++) { //k goes from i to j , i inclusive,
                    // to remember, see, we r using k+1, so cant be ==j, and first value T[0][0] can be used so k can equal i

                    int t_ik = T[i][k] + F[i][k];
                    int t_kj = T[k + 1][j] + F[k + 1][j];

                    if (oper[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += (t_ik * t_kj) - (T[i][k] * T[k + 1][j]);
                    }
                    if (oper[k] == '|') {
                        T[i][j] += (t_ik * t_kj) - (F[i][k] * F[k + 1][j]);
                        F[i][j] += F[i][k] * F[k + 1][j];
                    }
                    if (oper[k] == '^') {
                        T[i][j] += T[i][k] * F[k + 1][j] + F[i][k] * T[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        print(T);
        //from gfg
        for (int gap=1; gap<n; ++gap)
        {
            for (int i=0, j=gap; j<n; ++i, ++j)
            {
                T[i][j] = F[i][j] = 0;
                for (int g=0; g<gap; g++)
                {
                    // Find place of parenthesization using current value
                    // of gap
                    int k = i + g;

                    // Store Total[i][k] and Total[k+1][j]
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k+1][j] + F[k+1][j];

                    // Follow the recursive formulas according to the current
                    // operator
                    if (oper[k] == '&')
                    {
                        T[i][j] += T[i][k]*T[k+1][j];
                        F[i][j] += (tik*tkj - T[i][k]*T[k+1][j]);
                    }
                    if (oper[k] == '|')
                    {
                        F[i][j] += F[i][k]*F[k+1][j];
                        T[i][j] += (tik*tkj - F[i][k]*F[k+1][j]);
                    }
                    if (oper[k] == '^')
                    {
                        T[i][j] += F[i][k]*T[k+1][j] + T[i][k]*F[k+1][j];
                        F[i][j] += T[i][k]*T[k+1][j] + F[i][k]*F[k+1][j];
                    }
                }
            }
        }
        System.out.println();
        print(T);
    }
    public static void print(int[][] T){
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T.length; j++) {
                System.out.printf("%d ", T[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String symbols = "TTFT";
        String operators = "|&^";
        getParanthesis(symbols.toCharArray(), operators.toCharArray());

    }
}
