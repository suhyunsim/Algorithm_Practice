package main.java.com.poogle.PG.Q43162;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int cnt;
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(solution(5, new int[][]{{1, 1, 0, 1, 1}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 1, 1, 1}, {0, 0, 1, 1, 1}}));
        System.out.println(solution2(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution2(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(solution2(5, new int[][]{{1, 1, 0, 1, 1}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 1, 1, 1}, {0, 0, 1, 1, 1}}));
    }

    private static int solution(int n, int[][] computers) {
        cnt = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n, computers);
            }
        }
        return cnt;
    }

    private static void bfs(int i, int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int j = 0; j < n; j++) {
                if (!visited[j] && computers[now][j] == 1 && now != j) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
        cnt++;
    }

    private static int solution2(int n, int[][] computers) {
        cnt = 0;
        visited = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i, visited, computers);
            }
        }
        return cnt;
    }

    private static void dfs(int i, boolean[] visited, int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (!visited[j] && computers[i][j] == 1) {
                dfs(j, visited, computers);
            }
        }
    }
}
