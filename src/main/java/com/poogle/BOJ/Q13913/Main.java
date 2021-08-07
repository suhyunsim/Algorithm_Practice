package main.java.com.poogle.BOJ.Q13913;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static final int MAX = 200000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        int[] from = new int[MAX];
        check[n] = true;
        dist[n] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int now = queue.remove();
            if (now - 1 >= 0) {
                if (!check[now - 1]) {
                    queue.add(now - 1);
                    check[now - 1] = true;
                    dist[now - 1] = dist[now] + 1;
                    from[now - 1] = now;
                }
            }
            if (now + 1 < MAX) {
                if (!check[now + 1]) {
                    queue.add(now + 1);
                    check[now + 1] = true;
                    dist[now + 1] = dist[now] + 1;
                    from[now + 1] = now;
                }
            }
            if (now * 2 < MAX) {
                if (!check[now * 2]) {
                    queue.add(now * 2);
                    check[now * 2] = true;
                    dist[now * 2] = dist[now] + 1;
                    from[now * 2] = now;
                }
            }
        }
        System.out.println(dist[k]);
        //재귀로 풀이
//        print(from, n, k);

        //스택으로 풀이
        Stack<Integer> ans = new Stack<>();
        for (int i = k; i != n; i = from[i]) {
            ans.push(i);
        }
        ans.push(n);
        while (!ans.isEmpty()) {
            System.out.print(ans.pop() + " ");
        }
        System.out.println();
    }

    private static void print(int[] from, int n, int k) {
        if (n != k) print(from, n, from[k]);
        System.out.print(k + " ");
    }
}
