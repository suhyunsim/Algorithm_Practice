package main.java.com.poogle.BOJ.Q9663;

import java.util.Scanner;

public class Main {
    static int n;
    static int ans;
    static boolean[][] a = new boolean[15][15];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        calc(0);
        System.out.println(ans);
    }

    private static void calc(int row) {
        if (row == n) ans += 1;
        for (int col = 0; col < n; col++) {
            a[row][col] = true;
            if (check(row, col)) {
                calc(row + 1);
            }
            a[row][col] = false;
        }
    }

    private static boolean check(int row, int col) {
        // |
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            if (a[i][col]) return false;
        }
        // \
        int x = row - 1;
        int y = col - 1;
        while (x >= 0 && y >= 0) {
            if (a[x][y]) return false;
            x -= 1;
            y -= 1;
        }
        // /
        x = row - 1;
        y = col + 1;
        while (x >= 0 && y < n) {
            if (a[x][y]) return false;
            x -= 1;
            y += 1;
        }
        return true;
    }
}
