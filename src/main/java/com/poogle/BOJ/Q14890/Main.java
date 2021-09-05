package main.java.com.poogle.BOJ.Q14890;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        // 행 검사
        for (int i = 0; i < n; i++) {
            int[] d = new int[n];
            for (int j = 0; j < n; j++) {
                d[j] = a[i][j];
            }
            if (go(d, l)) ans += 1;
        }
        // 열 검사
        for (int j = 0; j < n; j++) {
            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = a[i][j];
            }
            if (go(d, l)) ans += 1;
        }
        System.out.println(ans);
    }

    private static boolean go(int[] a, int l) {
        //한 줄 검사
        int n = a.length;
        boolean[] c = new boolean[n];
        for (int i = 1; i < n; i++) {
            //인접한 칸 높이가 다르면 -> 경사로 O
            if (a[i - 1] != a[i]) {
                int diff = a[i] - a[i - 1];
                if (diff < 0) diff = -diff;
                // 낮/높 차이 1이어야 함
                if (diff != 1) return false;
                if (a[i - 1] < a[i]) {
                    for (int j = 1; j <= l; j++) {
                        // 경사로 놓다가 범위를 벗어나는 경우
                        if (i - j < 0) return false;
                        //낮은 지점의 칸 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
                        if (a[i - 1] != a[i - j]) return false;
                        //경사로 놓은 곳에 또 놓은 경우
                        if (c[i - j]) return false;
                        c[i - j] = true;
                    }
                } else {
                    for (int j = 0; j < l; j++) {
                        //경사로 놓다가 범위 벗어나는 경우
                        if (i + j >= n) return false;
                        //낮은 지점의 칸 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
                        if (a[i] != a[i + j]) return false;
                        //경사로 놓은 곳에 또 놓은 경우
                        if (c[i + j]) return false;
                        c[i + j] = true;
                    }
                }
            }
        }
        return true;
    }
}
