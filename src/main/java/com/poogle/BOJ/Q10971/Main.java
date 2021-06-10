package main.java.com.poogle.BOJ.Q10971;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i;
        }
        int ans = Integer.MAX_VALUE;
        do {
            if (d[0] != 0) break;
            boolean ok = true;
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (a[d[i]][d[i + 1]] == 0) {
                    ok = false;
                } else {
                    sum += a[d[i]][d[i + 1]];
                }
            }
            if (ok && a[d[n - 1]][d[0]] != 0) {
                sum += a[d[n - 1]][d[0]];
                if (ans > sum) {
                    ans = sum;
                }
            }
        } while (nextPermutation(d));
        System.out.println(ans);
    }

    private static boolean nextPermutation(int[] d) {
        int i = d.length - 1;
        while (i > 0 && d[i - 1] >= d[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = d.length - 1;
        while (d[j] <= d[i - 1]) {
            j -= 1;
        }
        int tmp = d[j];
        d[j] = d[i - 1];
        d[i - 1] = tmp;
        j = d.length - 1;
        while (i < j) {
            tmp = d[j];
            d[j] = d[i];
            d[i] = tmp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
