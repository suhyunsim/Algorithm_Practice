package main.java.com.poogle.BOJ.Q1992;

import java.util.Scanner;

public class Main {
    public static int[][] video;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        video = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }
        tree(0, 0, n);
        System.out.println(sb.toString());
    }

    private static void tree(int x, int y, int n) {
        if (check(x, y, n)) {
            sb.append(video[x][y]);
            return;
        }
        sb.append("(");
        int half = n / 2;
        tree(x, y, half);
        tree(x, y + half, half);
        tree(x + half, y, half);
        tree(x + half, y + half, half);
        sb.append(")");
    }

    private static boolean check(int x, int y, int n) {
        int value = video[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (value != video[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
