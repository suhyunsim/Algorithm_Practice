package main.java.com.poogle.BOJ.Q1248;

import java.util.Scanner;

public class Main {
    static int n;
    static int[] answer;
    static int[][] sign;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answer = new int[n];
        sign = new int[n][n];
        String s = sc.next();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char x = s.charAt(cnt);
                if (x == '0') {
                    sign[i][j] = 0;
                } else if (x == '+') {
                    sign[i][j] = 1;
                } else if (x == '-') {
                    sign[i][j] = -1;
                }
                cnt += 1;
            }
        }
        go(0);
        for (int i = 0; i < n; i++) {
            System.out.println(answer[i] + " ");
        }
        System.out.println();
    }

    private static boolean go(int index) {
        if (index == n) {
            return true;
        }
        if (sign[index][index] == 0) {
            answer[index] = 0;
            return check(index) && go(index + 1);
        }
        //index번째 수를 i라고 결정했다고 가정, 검사하기 -1 ~ -10도 가능
        for (int i = 1; i <= 10; i++) {
            answer[index] = sign[index][index] * i;
            if (check(index) && go(index + 1)) return true;
        }
        return false;
    }

    private static boolean check(int index) {
        int sum = 0;
        for (int i = index; i >= 0; i--) {
            sum += answer[i];
            if (sign[i][index] == 0) {
                if (sum != 0) return false;
            } else if (sign[i][index] < 0) {
                if (sum >= 0) return false;
            } else if (sign[i][index] > 0) {
                if (sum <= 0) return false;
            }
        }
        return true;
    }
}
