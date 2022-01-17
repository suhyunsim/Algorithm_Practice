package main.java.com.poogle.BOJ.Q11729;

import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sb.append((1 << n) - 1).append('\n');
        calculate(1, 3, n);
        System.out.println(sb);
    }

    private static void calculate(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        calculate(a, 6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append("\n");
        calculate(6 - a - b, b, n - 1);
    }
}
