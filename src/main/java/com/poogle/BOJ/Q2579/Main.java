package main.java.com.poogle.BOJ.Q2579;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[301];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            bw.write(String.valueOf(stairs[1]));
            bw.flush();
            bw.close();
            return;
        }
        // d[i][j]: 현재까지 j개 계단 연속 -> i번째 계단까지 올라갔을 때 점수 합 최댓값, i번째 밟음
        int[][] d = new int[301][3];
        d[1][1] = stairs[1];
        d[1][2] = 0;
        d[2][1] = stairs[2];
        d[2][2] = stairs[1] + stairs[2];

        for (int i = 3; i <= n; i++) {
            d[i][1] = Math.max(d[i - 2][1], d[i - 2][2]) + stairs[i];
            d[i][2] = d[i - 1][1] + stairs[i];
        }
        bw.write(String.valueOf(Math.max(d[n][1], d[n][2])));
        bw.flush();
        bw.close();
    }
}
