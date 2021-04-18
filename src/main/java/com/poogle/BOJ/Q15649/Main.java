package main.java.com.poogle.BOJ.Q15649;

import java.util.Scanner;

public class Main {
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];

    private static void go(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (c[i]) continue;
            c[i] = true; //함수 호출 전에 준비
            a[index] = i;
            go(index + 1, n, m);
            c[i] = false; //호출 후에 index에는 다른 i가 들어가야 함
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, n, m);
    }

}
