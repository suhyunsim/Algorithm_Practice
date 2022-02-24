package main.java.com.poogle.BOJ.Q9461;

import java.util.Scanner;

public class Main {
    static Long[] padovan = new Long[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        padovan[0] = 0L;
        padovan[1] = 1L;
        padovan[2] = 1L;
        padovan[3] = 1L;
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(calculate(n));
        }
    }

    private static Long calculate(int n) {
        if (padovan[n] == null) {
            padovan[n] = calculate(n - 2) + calculate(n - 3);
        }
        return padovan[n];
    }
}
