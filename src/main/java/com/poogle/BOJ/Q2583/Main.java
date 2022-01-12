package main.java.com.poogle.BOJ.Q2583;

import java.util.*;

public class Main {

    static int n;
    static int m;
    static int k;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[m][n];
        board = new int[m][n];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();
            for (int y = ly; y < ry; y++) {
                for (int x = lx; x < rx; x++) {
                    board[y][x] = 1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    list.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt); //영역 개수
        Collections.sort(list); //영역 넓이 오름차순
        for (int size : list) {
            System.out.print(size + " ");
        }
    }

    private static int bfs(int x, int y) {
        int size = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (!visited[nx][ny] && board[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                    size++;
                }
            }
        }
        return size;
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}