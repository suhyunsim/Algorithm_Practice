package main.java.com.poogle.BOJ.Q14226;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); //s 초기값
        queue.add(0); //c 초기값
        d[1][0] = 0;
        while (!queue.isEmpty()) {
            int s = queue.remove();
            int c = queue.remove();
            if (d[s][s] == -1) { //방문 안했으면?
                d[s][s] = d[s][c] + 1;
                queue.add(s);
                queue.add(s);
            }
            if (s + c <= n && d[s + c][c] == -1) {
                d[s + c][c] = d[s][c] + 1;
                queue.add(s + c);
                queue.add(c);
            }
            if (s - 1 >= 0 && d[s - 1][c] == -1) {
                d[s - 1][c] = d[s][c] + 1;
                queue.add(s - 1);
                queue.add(c);
            }
        }
        int ans = -1;
        for (int i = 0; i <= n; i++) {
            if (d[n][i] != -1) {
                if (ans == -1 || ans > d[n][i]) {
                    ans = d[n][i];
                }
            }
        }
        System.out.println(ans);
    }
}
