package main.java.com.poogle.BOJ.Q2217;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        Arrays.sort(weight);
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, weight[n - i] * i);
        }
        System.out.println(answer);
    }
}
