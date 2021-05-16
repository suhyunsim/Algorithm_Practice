package main.java.com.poogle.BOJ.Q15650;

import java.util.Scanner;

public class Main {
    static int[] a = new int[10];
/* 순서로 풀이
    //index번 째에 올 수 있는 수의 범위의 시작: start
    static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m - 1) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            a[index] = i;
            go(index + 1, i + 1, n, m);
        }
    }
*/
    //선택으로 풀이
    static void go(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m - 1) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        if (index > n) return;
        //선택했을 때
        a[selected] = index;
        go(index + 1, selected + 1, n, m);
        //선택하지 않았을 때
        a[selected] = 0;
        go(index + 1, selected, n, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//순서        go(0, 1, n, m);
        //선택
        go(1, 0, n, m);
    }
}
