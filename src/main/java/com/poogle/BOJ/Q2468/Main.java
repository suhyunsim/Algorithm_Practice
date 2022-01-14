package main.java.com.poogle.BOJ.Q2468;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int[][] board;
    static boolean[][] checked;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n + 1][n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                max = Math.max(board[i][j], max);
            }
        }
        int cnt;
        int maxCnt = 0;
        for (int h = 0; h <= max; h++) {
            checked = new boolean[n + 1][n + 1];
            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!checked[i][j] && board[i][j] > h) {
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.println(maxCnt);
    }

    private static void bfs(int i, int j, int h) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        checked[i][j] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!checked[nx][ny] && board[nx][ny] > h) {
                    checked[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }
}

class Node {
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x, y;
}
