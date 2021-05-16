package main.java.com.poogle.BOJ.Q15649;

import java.util.Scanner;

public class Main {
    //사용한지 여부를 알기 위해 (c[i]: 사용했으면 true)
    static boolean[] c = new boolean[10];
    //고른 수열을 저장
    static int[] a = new int[10];

    //index번 째의 수를 결정
    private static void go(int index, int n, int m) {
        if (index == m) { //마지막꺼 도착
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
            // 1 ~ N 중에서 사용하지 않은 수 찾기
            if (c[i]) continue;
            //수 i를 사용하기
            c[i] = true; //함수 호출 전에 사용했다고 준비
            a[index] = i;
            go(index + 1, n, m);
            c[i] = false; //호출 후에 index에는 다른 i가 들어가야 함 -> 다른 i는 사용하지 않은 상태
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, n, m);
    }

}
