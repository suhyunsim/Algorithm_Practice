package main.java.com.poogle.BOJ.Q1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();
        String[] alpha = new String[c];
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = sc.next();
        }
        Arrays.sort(alpha);

        go(l, alpha, "", 0);
    }

    private static void go(int l, String[] alpha, String pwd, int i) {
        if (pwd.length() == l) {
            if (check(pwd)) {
                System.out.println(pwd);
                return;
            }
        }
        if (alpha.length <= i) return;
        go(l, alpha, pwd + alpha[i], i + 1);
        go(l, alpha, pwd, i + 1);
    }

    private static boolean check(String pwd) {
        int m = 0;
        int j = 0;
        for (char c : pwd.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                m++;
            } else {
                j++;
            }
        }
        return m >= 1 && j >= 2;
    }
}
