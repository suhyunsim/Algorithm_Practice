package main.java.com.poogle.BOJ.Q17626;

import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        calculate(n);
        System.out.println(dp[n]);
    }

    private static void calculate(int n) {
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
    }
}
