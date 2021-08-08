package main.java.com.poogle.BOJ.Q1261;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int[][] dist = new int[n][m];
        ArrayDeque<Place> deque = new ArrayDeque<>();
//        Queue<Place> nowQueue = new LinkedList<>();
//        Queue<Place> nextQueue = new LinkedList<>();
//        nowQueue.offer(new Place(0, 0));
        deque.offer(new Place(0, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 0;
//        while (!nowQueue.isEmpty()) {
//            Place p = nowQueue.remove();
        while (!deque.isEmpty()) {
            Place p = deque.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dist[nx][ny] == -1) {
                        if (a[nx][ny] == 0) {
                            dist[nx][ny] = dist[x][y];
//                            nowQueue.offer(new Place(nx, ny));
                            deque.addFirst(new Place(nx, ny));
                        } else {
                            dist[nx][ny] = dist[x][y] + 1;
//                            nextQueue.offer(new Place(nx, ny));
                            deque.addLast(new Place(nx, ny));
                        }
                    }
                }
            }
//            if (nowQueue.isEmpty()) {
//                nowQueue = nextQueue;
//                nextQueue = new LinkedList<>();
//            }
        }
        System.out.println(dist[n - 1][m - 1]);
    }
}

class Place {
    int x, y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
