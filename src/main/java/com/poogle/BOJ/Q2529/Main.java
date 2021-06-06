package main.java.com.poogle.BOJ.Q2529;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int k;
    static char[] a = new char[20];
    static ArrayList<String> ans = new ArrayList<>();
    static boolean[] check = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            a[i] = sc.next().toCharArray()[0];
        }
        go(0, "");
        Collections.sort(ans);
        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));
    }

    private static void go(int index, String num) {
        if (index == k + 1) {
            ans.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (check[i]) continue;
            if (index == 0 || good(num.charAt(index - 1), (char)(i + '0'), a[index - 1])) {
                check[i] = true;
                go(index + 1, num + i);
                check[i] = false;
            }
        }
    }

    private static boolean good(char x, char y, char op) {
        if (op == '>') {
            if (x < y) return false;
        }
        if (op == '<') {
            if (x > y) return false;
        }
        return true;
    }
}
