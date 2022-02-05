package main.java.com.poogle.BOJ.Q1316;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            check(sc.next());
        }
        System.out.println(cnt);
    }

    private static void check(String word) {
        boolean[] alphabet = new boolean[26];
        if (word.length() == 1 || word.length() == 2) {
            cnt++;
            return;
        }
        char before = 0;
        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            if (before != now) {
                if (!alphabet[now - 97]) {
                    alphabet[now - 97] = true;
                    before = now;
                } else {
                    return;
                }
            }
        }
        cnt++;
    }
}
