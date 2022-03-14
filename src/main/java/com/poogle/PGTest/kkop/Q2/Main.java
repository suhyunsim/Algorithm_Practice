package main.java.com.poogle.PGTest.kkop.Q2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] distance = new int[10][10];
    static char[][] board = new char[10][10];
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                distance[i][j] = 0;
            }
        }
        boolean exit = false;
        for (int i = 0; i < 10; i++) {
            String row = br.readLine();
            for (int j = 0; j < 10; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'H') {
                    queue.add(new Node(i, j));
                    distance[i][j] = 0;
                } else if (board[i][j] == '.') {
                    distance[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            if (exit) break;
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
                if (board[nx][ny] == 'R' || distance[nx][ny] > 0) continue;
                distance[nx][ny] = distance[node.x][node.y] + 1;
                if (board[nx][ny] == 'M') {
                    exit = true;
                    System.out.println(distance[nx][ny] - 1);
                    break;
                }
                queue.offer(new Node(nx, ny));
            }
        }
        while (!queue.isEmpty()) queue.poll();
    }
}
class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
