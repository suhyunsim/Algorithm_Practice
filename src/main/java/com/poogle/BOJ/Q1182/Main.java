package main.java.com.poogle.BOJ.Q1182;

import java.util.Scanner;

public class Main {
    static int[] a;
    static int s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = go(0, 0);
        if (s == 0)
            ans -= 1; //크기가 양수인 부분수열
        System.out.println(ans);
    }

    private static int go(int i, int sum) {
        if (i == a.length) {
            if (sum == s)
                return 1;
            else
                return 0;
        }
        return go(i + 1, sum + a[i]) + go(i + 1, sum);
    }
}
