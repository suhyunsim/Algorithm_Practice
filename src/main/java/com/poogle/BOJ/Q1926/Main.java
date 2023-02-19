package main.java.com.poogle.BOJ.Q1926;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int max = 0;
    static int n;
    static int m;

    static int[][] picture;

    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picture = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                picture[i][j] = Integer.parseInt(row[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append("\n").append(max);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        int size = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (picture[nx][ny] == 0 || visited[nx][ny])
                    continue;
                queue.offer(new Node(nx, ny));
                visited[nx][ny] = true;
                size++;
            }
        }
        max = Math.max(size, max);
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
