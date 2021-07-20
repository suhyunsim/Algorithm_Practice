package main.java.com.poogle.BOJ.Q15988;

import java.util.Scanner;

public class Main {
    static final int LIMIT = 1000000 ;
    static final long MOD = 1000000009L ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] d = new long[LIMIT + 1];
        d[0] = 1;
        int t = sc.nextInt();
        for (int i = 0; i <= LIMIT; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    d[i] += d[i - j];
                }
            }
            d[i] %= MOD;
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}
