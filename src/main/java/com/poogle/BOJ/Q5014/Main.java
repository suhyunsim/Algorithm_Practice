package main.java.com.poogle.BOJ.Q5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int f, s, g, u, d;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt(); //최고층
        s = sc.nextInt(); //현재 위치
        g = sc.nextInt(); //도착지
        u = sc.nextInt(); //위
        d = sc.nextInt(); //아래
        visited = new int[f + 1];
        bfs(f, s, g, u, d);
    }

    private static void bfs(int f, int s, int g, int u, int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == g) {
                System.out.println(visited[now] - 1);
            }
            if (now + u <= f && visited[now + u] == 0) {
                visited[now + u] = visited[now] + 1;
                queue.offer(now + u);
            }
            if (now - d > 0 && visited[now - d] == 0) {
                visited[now - d] = visited[now] + 1;
                queue.offer(now - d);
            }
        }
        if (visited[g] == 0) System.out.println("use the stairs");
    }
}