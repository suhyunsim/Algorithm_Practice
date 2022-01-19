package main.java.com.poogle.BOJ.Q1074;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(calculate(n, r, c));
    }

    private static int calculate(int n, int r, int c) {
        if (n == 0) return 0;
        int half = 1 << n - 1;
        if (r < half && c < half) return calculate(n - 1, r, c);
        if (r < half && c >= half) return half * half + calculate(n - 1, r, c + half);
        if (r >= half && c < half) return 2 * half * half + calculate(n - 1, r + half, c);
        return 3 * half * half + calculate(n - 1, r + half, c + half);
    }
}
