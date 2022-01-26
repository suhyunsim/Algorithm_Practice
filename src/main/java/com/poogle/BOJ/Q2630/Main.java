package main.java.com.poogle.BOJ.Q2630;

import java.util.Scanner;

public class Main {
    static int[] ans = new int[2];
    static int[][] board = new int[128][128];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        calculate(n, 0, 0);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    private static void calculate(int n, int x, int y) {
        if (check(n, x, y)) {
            ans[board[x][y]]++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                calculate(n / 2, x + i * n / 2, y + j * n / 2);
            }
        }
    }

    private static boolean check(int n, int x, int y) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[x][y] != board[i][j]) return false;
            }
        }
        return true;
    }

}
