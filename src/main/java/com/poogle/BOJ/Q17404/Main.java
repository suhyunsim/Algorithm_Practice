package main.java.com.poogle.BOJ.Q17404;

import java.util.Scanner;

public class Main {
    static int[][] cost;
    static int[][] minCost;
    static final int MAX = 1000 * 1000;
    static int answer = MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cost = new int[n + 1][3];
        minCost = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        //첫 번째 집의 색을 고정해서 풀기
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i == k) {
                    //현재 색을 첫 번째 집 색으로 고정
                    minCost[1][i] = cost[1][i];
                } else {
                    minCost[1][i] = MAX;
                }
            }
            for (int i = 2; i <= n; i++) {
                minCost[i][0] = Math.min(minCost[i - 1][1], minCost[i - 1][2]) + cost[i][0];
                minCost[i][1] = Math.min(minCost[i - 1][0], minCost[i - 1][2]) + cost[i][1];
                minCost[i][2] = Math.min(minCost[i - 1][0], minCost[i - 1][1]) + cost[i][2];
            }
            for (int i = 0; i < 3; i++) {
                //첫번째 집 색이 k인 경우 마지막 집은 k가 아닌 색이 가능
                if (i != k) {
                    answer = Math.min(answer, minCost[n][i]);
                }
            }
        }

        System.out.println(answer);
    }
}
