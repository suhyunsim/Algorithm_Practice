package main.java.com.poogle.BOJ.Q1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int answer = 0;
        int now = 0;
        for (int i = 0; i < n; i++) {
            if (now <= meetings[i][0]) {
                now = meetings[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
