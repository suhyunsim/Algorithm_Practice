package main.java.com.poogle.BOJ.Q1012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int t;

    static int m;

    static int n;

    static int k;

    static int[][] board;

    static boolean[][] check;

    static int[] dx = {-1, 0, 1, 0};

    static int[] dy = {0, -1, 0, 1};

    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            board = new int[m][n];
            check = new boolean[m][n];
            while (k-- > 0) {
                board[sc.nextInt()][sc.nextInt()] = 1;
            }
            cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1 && !check[i][j]) {
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int x, int y) {
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(x, y));
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (check[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }
                check[nx][ny] = true;
                stack.add(new Node(nx, ny));
            }
        }
        cnt++;
    }

}

class Node {

    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
