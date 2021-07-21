package main.java.com.poogle.BOJ.Q11057;

import java.util.Scanner;

public class Main {
    static final long MOD = 10007;
    static long[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n + 1][10];
        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += d[i - 1][k];
                    d[i][j] %= MOD;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += d[n][i];
        }
        ans %= MOD;
        System.out.println(ans);
    }
}
