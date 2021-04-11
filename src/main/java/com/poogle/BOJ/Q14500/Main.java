package main.java.com.poogle.BOJ.Q14500;

import java.util.Scanner;

public class Main {
    static int[][][] block = {
            {{0, 1}, {0, 2}, {0, 3}}, //파랑 가로 길쭉
            {{1, 0}, {2, 0}, {3, 0}}, //파랑 세로 길쭉
            {{1, 0}, {1, 1}, {1, 2}}, //노랑 정사각형
            {{0, 1}, {1, 0}, {2, 0}}, //주황
            {{0, 1}, {0, 2}, {1, 2}},
            {{1, 0}, {2, 0}, {2, -1}},
            {{0, 1}, {0, 2}, {-1, 2}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{0, 1}, {0, 2}, {1, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 0}, {1, 1}},
            {{0, 1}, {-1, 1}, {-1, 2}}, //초록
            {{1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 1}, {1, 2}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, 1}, {0, 2}, {-1, 1}}, //핑크
            {{0, 1}, {0, 2}, {1, 1}},
            {{1, 0}, {2, 0}, {1, 1}},
            {{1, 0}, {2, 0}, {1, -1}}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 19; k++) {
                    boolean ok = true;
                    int sum = a[i][j];
                    for (int l = 0; l < 3; l++) {
                        int x = i + block[k][l][0];
                        int y = i + block[k][l][1];
                        if (0 <= x && x < n && 0 <= y && y < m) {
                            sum += a[x][y];
                        } else {
                            ok = false;
                            break;
                        }
                    }
                    if (ok && ans < sum) {
                        ans = sum;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
