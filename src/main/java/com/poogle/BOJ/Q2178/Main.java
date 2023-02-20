package main.java.com.poogle.BOJ.Q2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][] dist;

    static int N;
    static int M;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(row[j]);
                dist[i][j] = -1;
            }
        }
        dist[0][0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] < 0 && board[i][j] == 1) {
                    bfs(new Node(0, 0));
                }
            }
        }
        bw.write(String.valueOf(dist[N - 1][M - 1] + 1));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(Node firstNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(firstNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (dist[nx][ny] > -1 || board[nx][ny] == 0)
                    continue;
                dist[nx][ny] = dist[node.x][node.y] + 1;
                queue.offer(new Node(nx, ny));
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
