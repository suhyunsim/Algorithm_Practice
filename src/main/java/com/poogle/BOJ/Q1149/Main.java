package main.java.com.poogle.BOJ.Q1149;

import java.util.Scanner;

public class Main {
    static int[][] minCost;
    static int[][] cost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        minCost = new int[n + 1][3];
        cost = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            minCost[i][0] = Math.min(minCost[i - 1][1], minCost[i - 1][2]) + cost[i][0];
            minCost[i][1] = Math.min(minCost[i - 1][0], minCost[i - 1][2]) + cost[i][1];
            minCost[i][2] = Math.min(minCost[i - 1][0], minCost[i - 1][1]) + cost[i][2];
        }
        System.out.println(Math.min(Math.min(minCost[n][0], minCost[n][1]), minCost[n][2]));
    }
}
