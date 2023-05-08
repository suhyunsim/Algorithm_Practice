package main.java.com.poogle.BOJ.Q10026;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String[][] board;
    static int N;
    static boolean[][] checked;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        checked = new boolean[N][N];
        int cntN = count();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j].equals("G")) {
                    board[i][j] = "R";
                }
            }
        }

        checked = new boolean[N][N];
        int cntY = count();

        bw.write(cntN + " " + cntY);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!checked[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        checked[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (checked[nx][ny] || !board[nx][ny].equals(board[x][y])) {
                    continue;
                }
                checked[nx][ny] = true;
                queue.offer(new Node(nx, ny));
            }
        }
    }
}


class Node {

    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
