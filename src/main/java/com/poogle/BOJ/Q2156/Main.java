package main.java.com.poogle.BOJ.Q2156;

import java.util.Scanner;

public class Main {
    static int[][] d;
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1][3];
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2; j++) {
                if (j == 0) {
                    d[i][j] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
                } else if (j == 1) {
                    d[i][j] = d[i - 1][0] + a[i];
                } else {
                    d[i][j] = d[i - 1][1] + a[i];
                }
            }
        }
        System.out.println(Math.max(Math.max(d[n][0], d[n][1]), d[n][2]));
    }
}
