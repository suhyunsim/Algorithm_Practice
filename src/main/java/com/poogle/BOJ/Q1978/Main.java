package main.java.com.poogle.BOJ.Q1978;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        while (n-- > 0) {
            if (isPrime(sc.nextInt()))
                a += 1;
        }
        System.out.println(a);
        sc.close();
    }

    private static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        } else if (x == 2) {
            return true;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
