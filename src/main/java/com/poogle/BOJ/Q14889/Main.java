package main.java.com.poogle.BOJ.Q14889;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        System.out.println(go(0, first, second));
    }

    private static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
        if (index == n) {
            if (first.size() != n / 2) return -1;
            if (second.size() != n / 2) return -1;
            int t1 = 0;
            int t2 = 0;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    t1 += s[first.get(i)][first.get(j)];
                    t2 += s[second.get(i)][second.get(j)];
                }
            }
            return Math.abs(t1 - t2);
        }
        if (first.size() > n / 2) return -1;
        if (second.size() > n / 2) return -1;
        int ans = -1;
        first.add(index); //넣고
        int t1 = go(index + 1, first, second);
        if (ans == -1 || (t1 != -1 && ans > t1)) { //1) -1이면 최솟값이니 ans에 넣어주기 2) -1이 아니면 옳바른 방법 -> 현재와 최솟값 비교
            ans = t1;
        }
        first.remove(first.size() - 1); //빼주기
        second.add(index); //넣고
        int t2 = go(index + 1, first, second);
        if (ans == -1 || (t2 != -1 && ans > t2)) {
            ans = t2;
        }
        second.remove(second.size() - 1); //빼주기
        return ans;
    }
}
