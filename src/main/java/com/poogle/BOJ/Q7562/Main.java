package main.java.com.poogle.BOJ.Q7562;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] board = new int[n][n];
            int sx = sc.nextInt(); //현재
            int sy = sc.nextInt();
            int ex = sc.nextInt(); //이동
            int ey = sc.nextInt();
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], -1);
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(sx);
            queue.add(sy);
            board[sx][sy] = 0;
            while (!queue.isEmpty()) {
                int x = queue.remove();
                int y = queue.remove();
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (board[nx][ny] == -1) {
                            board[nx][ny] = board[x][y] + 1;
                            queue.add(nx);
                            queue.add(ny);
                        }
                    }
                }
            }
            System.out.println(board[ex][ey]);
        }
    }
}
