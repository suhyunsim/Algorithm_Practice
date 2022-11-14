package main.java.com.poogle.PG.Q77485;

import java.util.Arrays;

class Solution {

    static int[][] board;

    public static int[] solution(int rows, int columns, int[][] queries) {
        board = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = num++;
            }
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }

    private static int rotate(int[] query) {
        int r1 = query[0] - 1;
        int c1 = query[1] - 1;
        int r2 = query[2] - 1;
        int c2 = query[3] - 1;
        int tmp = board[r1][c1];
        int min = tmp;
        for (int i = r1; i < r2; i++) {
            board[i][c1] = board[i + 1][c1];
            min = Math.min(board[i][c1], min);
        }
        for (int i = c1; i < c2; i++) {
            board[r2][i] = board[r2][i + 1];
            min = Math.min(board[r2][i], min);
        }
        for (int i = r2; i > r1; i--) {
            board[i][c2] = board[i - 1][c2];
            min = Math.min(board[i][c2], min);
        }
        for (int i = c2; i > c1; i--) {
            board[r1][i] = board[r1][i - 1];
            min = Math.min(board[r1][i], min);
        }
        board[r1][c1 + 1] = tmp;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
        System.out.println(Arrays.toString(solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
        System.out.println(Arrays.toString(solution(100, 97, new int[][]{{1, 1, 100, 97}})));
    }
}