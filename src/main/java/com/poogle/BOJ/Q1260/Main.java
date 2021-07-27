package main.java.com.poogle.BOJ.Q1260;

import java.util.*;

public class Main {
    static ArrayList<Integer>[] a;
    static boolean[] c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }
        c = new boolean[n + 1];
        dfs(start);
        System.out.println();
        c = new boolean[n + 1];
        bfs(start);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        c[start] = true;
        while (!queue.isEmpty()) {
            int x = queue.remove();
            System.out.print(x + " ");
            for (int y : a[x]) {
                if (!c[y]) {
                    c[y] = true;
                    queue.add(y);
                }
            }
        }
    }

    private static void dfs(int start) {
        if (c[start]) return;
        c[start] = true;
        System.out.print(start + " ");
        for (int y : a[start]) {
            if (!c[y]) dfs(y);
        }
    }

}
