package main.java.com.poogle.BOJ.Q9095;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        //DP로 풀이
        int[] d = new int[11];
        d[0] = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    d[i] += d[i - j];
                }
            }
        }
        while (t-- > 0) {
//            System.out.println(go(0, sc.nextInt()));
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }

    //재귀로 풀이
    private static int go(int sum, int goal) {
        if (sum > goal) return 0;
        if (sum == goal) return 1;
        int now = 0;
        for (int i = 1; i <= 3; i++) {
            now += go(sum + i, goal);
        }
        return now;
    }
}
