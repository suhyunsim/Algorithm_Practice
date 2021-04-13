package main.java.com.poogle.BOJ.Q1748;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = String.valueOf(n).length();
        int ans = 0;
        if (k > 1) {
            for (int i = 1; i < k; i++) {
                ans += i * (Math.pow(10, i) - Math.pow(10, i - 1));
            }
            ans += k * (n - (Math.pow(10, k - 1) - 1));
        } else {
            ans = n;
        }
        System.out.println(ans);
    }
}
