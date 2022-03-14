package main.java.com.poogle.BOJ.Q11047;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cost[i] <= k) {
                int cnt = k / cost[i];
                answer += cnt;
                k -= cost[i] * cnt;
            }
        }
        System.out.println(answer);
    }
}
