package main.java.com.poogle.BOJ.Q1182;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = go(a, s, 0, 0);
        if (s == 0) ans -= 1; //크기가 양수인 부분수열
        System.out.println(ans);
    }

    private static int go(int[] a, int s, int i, int sum) {
        if (i == a.length) {
            if (sum == s) return 1;
            else return 0;
        }
        return go(a, s, i + 1, sum + a[i]) + go(a, s, i + 1, sum);
    }
}
