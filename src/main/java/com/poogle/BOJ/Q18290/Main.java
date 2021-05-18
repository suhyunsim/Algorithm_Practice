package main.java.com.poogle.BOJ.Q18290;

import java.util.Scanner;

public class Main {
    static int[][] a = new int[10][10];
    static boolean[][] c = new boolean[10][10];
    static int n, m, k;
    static int ans = -2147483647;
    //인접한 곳 좌표 차이 오 왼 아 위
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    //cnt: 선택한 칸의 개수
    //sum: 선택한 칸의 합
//    //1번 O((NM) ^ k): 선택한 칸이 같은데 선택한 순서가 다른 방법을 여러 번 계산 => 중복 선택
//    static void go(int cnt, int sum) {
//    //2번 px: previous의 x값: 이전에 선택한 행을 빼고 하기 위해서 -> 같은 행의 경우 중복 삭제 안됨
//    static void go(int px, int cnt, int sum) {
    //3번 (px, py): 이전에 선택한 칸 -> 중복 제거
//    static void go(int px, int py, int cnt, int sum) {
//    //4번: N과 M처럼 일차원으로 생각해서 풀이
    static void go(int prev, int cnt, int sum) {
        if (cnt == k) {
            if (ans < sum) ans = sum;
            return;
        }
//        for (int x = 0; x < n; x++) {
//            for (int y = 0; y < m; y++) {
//        for (int x = px; x < n; x++) {
//            for (int y = 0; y < m; y++) {
//        for (int x = px; x < n; x++) {
//            for (int y = (x == px ? py : 0); y < m; y++) {
        for (int j = prev + 1; j < n * m; j++) {
            //4번만
            int x = j / m;
            int y = j % m;
            if (c[x][y]) continue; //중복선택 판단
            boolean ok = true;
            //인접 네 방향 알아보기
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //범위 안에 있고 그 칸을 선택한 적 있으면 false
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (c[nx][ny]) ok = false;
                    //ok는 선택 가능하면 true, 아니면 false
                }
            }
            if (ok) {
                c[x][y] = true;
//                    go(cnt + 1, sum + a[x][y]);
//                    go(x, cnt + 1, sum + a[x][y]);
//                    go(x, y, cnt + 1, sum + a[x][y]);
                go(x * m + y, cnt + 1, sum + a[x][y]);
                c[x][y] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
//        go(0, 0);
//        go(0, 0, 0);
//        go(0, 0, 0, 0);
        go(-1, 0, 0);
        System.out.println(ans);
    }
}
