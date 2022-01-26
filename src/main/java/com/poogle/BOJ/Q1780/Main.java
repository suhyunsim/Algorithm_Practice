package main.java.com.poogle.BOJ.Q1780;

import java.util.Scanner;

public class Main {
    static int n;
    static int[][] board = new int[2200][2200];
    static int[] ans = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        calculate(0, 0, n);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    private static void calculate(int x, int y, int n) {
        if (check(x, y, n)) {
            ans[board[x][y] + 1]++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                calculate(x + i * n / 3, y + j * n / 3, n / 3);
            }
        }

    }

    private static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[x][y] != board[i][j]) return false;
            }
        }
        return true;
    }

}
