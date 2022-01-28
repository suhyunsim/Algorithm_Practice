package main.java.com.poogle.PG.Q92345;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    static int n = 0;
    static int m = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 0}, new int[]{1, 2}));
        System.out.println(solution(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, new int[]{1, 0}, new int[]{1, 2}));
        System.out.println(solution(new int[][]{{1, 1, 1, 1, 1}}, new int[]{0, 0}, new int[]{0, 4}));
        System.out.println(solution(new int[][]{{1}}, new int[]{0, 0}, new int[]{0}));
    }

    public static int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        return playerA(board, aloc, bloc, 0).turn;
    }

    private static Pair playerA(int[][] nowBoard, int[] aloc, int[] bloc, int turn) {
        Node node = new Node(aloc[0], aloc[1]);
        if (nowBoard[node.x][node.y] == 0) {
            return new Pair(false, turn);
        }
        // 이길 수 있는지 여부
        boolean flag = false;
        List<Integer> winner = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];
            if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
            if (nowBoard[nx][ny] == 1) {
                nowBoard[node.x][node.y] = 0;
                Pair pair = playerB(nowBoard, new int[]{nx, ny}, bloc, turn + 1);
                //nowBoard[node.x][node.y]가 이겼을 때의 최소 혹은 졌을 때의 최대 경로가 아닐 수 있음 -> 초기화
                nowBoard[node.x][node.y] = 1;
                if (!pair.isWinner) {
                    winner.add(pair.turn);
                    flag = true;
                } else {
                    loser.add(pair.turn);
                }
            }
        }
        if (flag) {
            return new Pair(true, Collections.min(winner));
        } else {
            //상하좌우 다 범위 밖 or 비어있는 발판 -> loser가 empty
            if (loser.isEmpty()) {
                return new Pair(false, turn);
            }
            return new Pair(false, Collections.max(loser));
        }
    }

    private static Pair playerB(int[][] nowBoard, int[] aloc, int[] bloc, int turn) {
        Node node = new Node(bloc[0], bloc[1]);
        if (nowBoard[node.x][node.y] == 0) {
            return new Pair(false, turn);
        }
        boolean flag = false;
        List<Integer> winner = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];
            if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
            if (nowBoard[nx][ny] == 1) {
                nowBoard[node.x][node.y] = 0;
                Pair pair = playerA(nowBoard, aloc, new int[]{nx, ny}, turn + 1);
                //nowBoard[node.x][node.y]가 이겼을 때의 최소 혹은 졌을 때의 최대 경로가 아닐 수 있음 -> 초기화
                nowBoard[node.x][node.y] = 1;
                if (!pair.isWinner) {
                    winner.add(pair.turn);
                    flag = true;
                } else {
                    loser.add(pair.turn);
                }
            }
        }
        if (flag) {
            return new Pair(true, Collections.min(winner));
        } else {
            //상하좌우 다 범위 밖 or 비어있는 발판 -> loser가 empty
            if (loser.isEmpty()) {
                return new Pair(false, turn);
            }
            return new Pair(false, Collections.max(loser));
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

class Pair {
    //이번 턴에 움직여야 하는 플레이어의 승패 여부
    boolean isWinner;
    //총 이동 횟수
    int turn;
    public Pair(boolean isWinner, int turn) {
        this.isWinner = isWinner;
        this.turn = turn;
    }
}