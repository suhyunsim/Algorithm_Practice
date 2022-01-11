package main.java.com.poogle.PG.Q81302;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dx = {-1, 0, 1, 0};

    static int[] dy = {0, -1, 0, 1};

    static int n = 5;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {
            "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {
            "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = isCorrect(places[i]);
        }

        return answer;
    }

    private static int isCorrect(String[] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) == 'P') {
                    if (!bfs(i, j, board)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    private static boolean bfs(int x, int y, String[] board) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        boolean[][] check = new boolean[n][n];
        check[x][y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int manLen = Math.abs(x - nx) + Math.abs(y - ny);
                if (nx >= n || nx < 0 || ny >= n || ny < 0) {
                    continue;
                }
                if (check[nx][ny] || manLen > 2) {
                    continue;
                }
                check[nx][ny] = true;
                if (board[nx].charAt(ny) == 'X') {
                    continue;
                } else if (board[nx].charAt(ny) == 'P') {
                    return false;
                } else {
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        return true;
    }

}

class Node {

    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
