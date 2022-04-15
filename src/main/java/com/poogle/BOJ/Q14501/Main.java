package main.java.com.poogle.BOJ.Q14501;

import java.util.Scanner;

public class Main {
    static int[] t;
    static int[] p;
    static int n;
    static int ans = 0;
    static int[] d;

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        t = new int[n + 1];
//        p = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            t[i] = sc.nextInt();
//            p[i] = sc.nextInt();
//        }
//        go(1, 0);
//        System.out.println(ans);
//    }

//    private static void go(int day, int sum) {
//        if (day == n + 1) {
//            if (ans < sum)
//                ans = sum;
//            return;
//        }
//        if (day > n + 1) {
//            return;
//        }
//        go(day + t[day], sum + p[day]);
//        go(day + 1, sum);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];
        d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) {
                d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
            }
            d[i + 1] = Math.max(d[i + 1], d[i]);
        }
        System.out.println(d[n]);
    }

}
