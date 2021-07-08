package main.java.com.poogle.BOJ.Q2178;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            List<Integer> list = Arrays.stream(sc.next().split("")).map(Integer::new).collect(Collectors.toList());
            for (int j = 0; j < m; j++) {
                board[i][j] = list.get(j);
            }
        }
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 0;
        Node first = new Node(0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && dist[i][j] < 0) {
                    bfs(first);
                }
            }
        }
        cnt = dist[n - 1][m - 1] + 1;
        System.out.println(cnt);
    }

    private static void bfs(Node first) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(first);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] >= 0 || board[nx][ny] == 0) continue;
                dist[nx][ny] = dist[node.x][node.y] + 1;
                queue.add(new Node(nx, ny));
            }
        }
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
