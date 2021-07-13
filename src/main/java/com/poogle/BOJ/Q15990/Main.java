package main.java.com.poogle.BOJ.Q15990;

import java.util.Scanner;

public class Main {
    static final int LIMIT = 100000;
    static final long MOD = 1000000009L;
    static long[][] d = new long[LIMIT + 1][4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= LIMIT; i++) {
            if (i - 1 >= 0) {
                d[i][1] = d[i - 1][2] + d[i - 1][3];
                if (i == 1) {
                    d[i][1] = 1;
                }
            }
            if (i - 2 >= 0) {
                d[i][2] = d[i -2][1] + d[i - 2][3];
                if (i == 2) {
                    d[i][2] = 1;
                }
            }
            if (i - 3 >= 0) {
                d[i][3] = d[i -3][1] + d[i - 3][2];
                if (i == 3) {
                    d[i][3] = 1;
                }
            }
            d[i][1] %= MOD;
            d[i][2] %= MOD;
            d[i][3] %= MOD;
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println((d[n][1] + d[n][2] + d[n][3]) % MOD);
        }
    }
}
