package main.java.com.poogle.BOJ.Q1707;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        while (k-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer>[] a = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                a[u].add(v);
                a[v].add(u);
            }
            int[] color = new int[n + 1];
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    if (!dfs(a, color, i, 1)) {
                        ok = false;
                    }
                }
            }
            if (ok) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean dfs(ArrayList<Integer>[] a, int[] color, int now, int c) {
        color[now] = c; //c는 1 or 2, node가 c일 때 next는 3 - c
        for (int next : a[now]) {
            if (color[next] == 0) {
                if (!dfs(a, color, next, 3 - c)) return false;
            } else if (color[next] == color[now]) return false;
        }
        return true;
    }
}
