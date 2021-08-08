package main.java.com.poogle.BOJ.Q13549;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        check[n] = true;
        dist[n] = 0;
        //큐 두개로 풀이
//        Queue<Integer> nowQueue = new LinkedList<>();
//        Queue<Integer> nextQueue = new LinkedList<>();
//        nowQueue.add(n);
//        while (!nowQueue.isEmpty()) {
//            int now = nowQueue.remove();
//            for (int next : new int[]{now * 2, now - 1, now + 1}) {
//                if (next >= 0 && next < MAX) {
//                    if (!check[next]) {
//                        check[next] = true;
//                        if (now * 2 == next) {
//                            nowQueue.add(next);
//                            dist[next] = dist[now];
//                        } else {
//                            nextQueue.add(next);
//                            dist[next] = dist[now] + 1;
//                        }
//                    }
//                }
//            }
//            if (nowQueue.isEmpty()) {
//                nowQueue = nextQueue;
//                nextQueue = new LinkedList<>();
//            }
//        }
//        System.out.println(dist[k]);
        // 덱으로 풀이
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        while (!deque.isEmpty()) {
            int now = deque.poll();
            for (int next : new int[]{now * 2, now - 1, now + 1}) {
                if (next >= 0 && next < MAX) {
                    if (!check[next]) {
                        check[next] = true;
                        if (now * 2 == next) {
                            deque.addFirst(next);
                            dist[next] = dist[now];
                        } else {
                            deque.addLast(next);
                            dist[next] = dist[now] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(dist[k]);
    }
}
