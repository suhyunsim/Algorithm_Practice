package main.java.com.poogle.BOJ.Q2606;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, e, result;
    static ArrayList<Integer>[] graph = new ArrayList[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(1);
        System.out.println(result - 1);
    }

    private static void dfs(int x) {
        result++;
        visited[x] = true;
        for (int i = 0; i < graph[x].size(); i++) {
            int y = graph[x].get(i);
            if (!visited[y]) {
                dfs(y);
            }
        }
    }
}
