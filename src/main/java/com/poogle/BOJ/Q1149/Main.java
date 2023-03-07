package main.java.com.poogle.BOJ.Q1149;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] minCost = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            minCost[i][0] = Math.min(minCost[i - 1][1], minCost[i - 1][2]) + cost[i][0];
            minCost[i][1] = Math.min(minCost[i - 1][0], minCost[i - 1][2]) + cost[i][1];
            minCost[i][2] = Math.min(minCost[i - 1][0], minCost[i - 1][1]) + cost[i][2];
        }
        bw.write(String.valueOf(Math.min(Math.min(minCost[N][0], minCost[N][1]), minCost[N][2])));
        bw.flush();
        bw.close();
        br.close();
    }
}
