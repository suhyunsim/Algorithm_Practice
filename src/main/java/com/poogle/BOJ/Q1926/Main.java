package main.java.com.poogle.BOJ.Q1926;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    static int paintCnt = 0;
    static int paintSize = 0;
    static boolean[][] check;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !check[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(paintCnt);
        System.out.println(paintSize);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        int size = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (check[nx][ny] || board[nx][ny] == 0) continue;
                check[nx][ny] = true;
                queue.add(new Node(nx, ny));
            }
        }
        paintCnt++;
        if (size > 1) size--;
        paintSize = Math.max(paintSize, size);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
