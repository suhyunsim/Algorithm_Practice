package main.java.com.poogle.BOJ.Q14225;

import java.util.Scanner;

public class Main {
    static boolean[] c = new boolean[20 * 100000 + 10]; // N*수의 크기
    static int[] a = new int[20];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        go(0, 0);
        for (int i = 1;; i++) {
            if (!c[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void go(int i, int sum) {
        if (i == n) {
            c[sum] = true;
            return;
        }
        go(i + 1, sum + a[i]);
        go(i + 1, sum);
    }
}
