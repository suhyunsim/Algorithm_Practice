package main.java.com.poogle.BOJ.Q4179;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[][] board = new String[R][C];
        int[][] fireDist = new int[R][C];
        int[][] jihoonDist = new int[R][C];
        Queue<Node> fireQueue = new LinkedList<>();
        Queue<Node> jihoonQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String[] row = br.readLine().split("");
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(jihoonDist[i], -1);
            for (int j = 0; j < C; j++) {
                board[i][j] = row[j];
                if (Objects.equals(board[i][j], "F")) {
                    fireQueue.add(new Node(i, j));
                    fireDist[i][j] = 0;
                }
                if (Objects.equals(board[i][j], "J")) {
                    jihoonQueue.add(new Node(i, j));
                    jihoonDist[i][j] = 0;
                }
            }
        }

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (!fireQueue.isEmpty()) {
            Node curr = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx >= R || nx < 0 || ny >= C || ny < 0)
                    continue;
                if (Objects.equals(board[nx][ny], "#") || fireDist[nx][ny] >= 0)
                    continue;
                fireDist[nx][ny] = fireDist[curr.x][curr.y] + 1;
                fireQueue.offer(new Node(nx, ny));
            }
        }

        while (!jihoonQueue.isEmpty()) {
            Node curr = jihoonQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx >= R || ny >= C || nx < 0 || ny < 0) {
                    bw.write(String.valueOf(jihoonDist[curr.x][curr.y] + 1));
                    bw.flush();
                    bw.close();
                    return;
                }
                if (Objects.equals(board[nx][ny], "#") || jihoonDist[nx][ny] >= 0)
                    continue;
                if (fireDist[nx][ny] <= jihoonDist[curr.x][curr.y] + 1 && fireDist[nx][ny] != -1)
                    continue;
                jihoonDist[nx][ny] = jihoonDist[curr.x][curr.y] + 1;
                jihoonQueue.offer(new Node(nx, ny));
            }
        }
        bw.write("IMPOSSIBLE");
        bw.flush();
        bw.close();
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
