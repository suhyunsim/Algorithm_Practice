package main.java.com.poogle.BOJ.Q2225;

import java.util.Scanner;

public class Main {
    static long MOD = 1000000000L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] d = new long[k + 1][n + 1];
        d[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    d[i][j] += d[i - 1][j - l];
                    d[i][j] %= MOD;
                }
            }
        }
        System.out.println(d[k][n]);
    }
}
