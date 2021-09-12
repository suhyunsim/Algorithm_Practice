package main.java.com.poogle.BOJ.Q15685;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static boolean[][] c = new boolean[101][101];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            int dir = sc.nextInt();
            int gen = sc.nextInt();
            ArrayList<Integer> dirs = curve(dir, gen);
            c[x][y] = true;
            for (int d : dirs) {
                x += dx[d];
                y += dy[d];
                c[x][y] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                if (c[i][j] && c[i][j + 1] && c[i + 1][j] && c[i + 1][j + 1]) ans += 1;
            }
        }
        System.out.println(ans);
    }

    private static ArrayList<Integer> curve(int dir, int gen) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(dir);
        for (int g = 1; g <= gen; g++) {
            ArrayList<Integer> tmp = new ArrayList<>(ans);
            Collections.reverse(tmp);
            for (int i = 0; i < tmp.size(); i++) {
                tmp.set(i, (tmp.get(i) + 1) % 4);
            }
            ans.addAll(tmp);
        }
        return ans;
    }
}
