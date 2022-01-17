package main.java.com.poogle.BOJ.Q1629;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        System.out.println(calculate(a, b, c) % c);
    }

    private static long calculate(long a, long b, long c) {
        if (b == 0) return 1;
        else if (b == 1) return a;
        long tmp = calculate(a, b / 2, c) % c;
        if (b % 2 == 0) return (tmp * tmp) % c; //짝수일 때
        else return (((tmp * tmp) % c) * a) % c; //홀수일 때
    }
}
