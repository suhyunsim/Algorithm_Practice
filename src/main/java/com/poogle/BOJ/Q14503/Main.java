package main.java.com.poogle.BOJ.Q14503;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int x = sc.nextInt();
        int y = sc.nextInt();
        int dir = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (true) {
            /*
            0: 청소 X
            1: 벽
            2: 청소 O
             */
            if (a[x][y] == 0) {
                //현재 위치 청소
                a[x][y] = 2;
            }
            // * 네 방향 모두 이미 청소된 곳이거나 벽인 경우
            if (a[x + 1][y] != 0 && a[x - 1][y] != 0 && a[x][y - 1] != 0 && a[x][y + 1] != 0) {
                // 뒤에도 벽이라 후진 X -> 멈춤
                if (a[x - dx[dir]][y - dy[dir]] == 1) break;
                else {
                    // 방향 유지하고 한 칸 후진 -> *로 돌아가기
                    x -= dx[dir];
                    y -= dy[dir];
                }
            } else {
                dir = (dir + 3) % 4;
                //왼쪽에 청소 안했으면 그 방향으로 회전
                if (a[x + dx[dir]][y + dy[dir]] == 0) {
                    // 한 칸 전진하고 처음으로 돌아가기
                    x += dx[dir];
                    y += dy[dir];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 2) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
