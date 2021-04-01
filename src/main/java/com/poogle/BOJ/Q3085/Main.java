package main.java.com.poogle.BOJ.Q3085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] candies = new char[n][n];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.next().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //행 확인
                if (j + 1 < n) {
                    //Swap
                    char t = candies[i][j];
                    candies[i][j] = candies[i][j + 1];
                    candies[i][j + 1] = t;
                    //몇 개인지 세기
                    int tmp = check(candies, i, i, j, j + 1);
                    if (ans < tmp) ans = tmp;
                    //돌려놓기
                    t = candies[i][j];
                    candies[i][j] = candies[i][j + 1];
                    candies[i][j + 1] = t;
                }
                //열 확인
                if (i + 1 < n) {
                    char t = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = t;
                    //몇 개인지 세기
                    int tmp = check(candies, i, i + 1, j, j);
                    if (ans < tmp) ans = tmp;
                    //돌려놓기
                    t = candies[i][j];
                    candies[i][j] = candies[i + 1][j];
                    candies[i + 1][j] = t;
                }
            }
        }
        System.out.println(ans);
    }

    //start, end, row, column
    private static int check(char[][] candies, int sr, int er, int sc, int ec) {
        int n = candies.length;
        int ans = 1;
        for (int i = sr; i <= er; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candies[i][j] == candies[i][j - 1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
        }
        for (int i = sc; i <= ec; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (candies[j][i] == candies[j - 1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
        }
        return ans;
    }
}
