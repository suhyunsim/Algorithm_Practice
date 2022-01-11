package main.java.com.poogle.BOJ.Q10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;

    static char[][] board;

    static boolean[][] check;

    static int[] dx = {-1, 0, 1, 0};

    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new char[n + 1][n + 1];
        check = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        //정상
        int cntN = count();

        //적록색약
        check = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }
        int cntS = count();

        System.out.println(cntN + " " + cntS);
    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        return cnt;
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        check[x][y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= n || nx < 0 || ny >= n || ny < 0) {
                    continue;
                }
                if (check[nx][ny] || board[x][y] != board[nx][ny]) {
                    continue;
                }
                check[nx][ny] = true;
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
