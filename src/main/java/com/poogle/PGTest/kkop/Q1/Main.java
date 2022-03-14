package main.java.com.poogle.PGTest.kkop.Q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] sizes = input.split(" ");
        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);
        calculate(n, m);
        System.out.println(cnt);
    }

    private static void calculate(int n, int m) {
        if (n <= 1 || m <= 1) {
            cnt += n * m;
            return;
        }
        cnt += n * m;
        cnt -= (n - 2) * (m - 2);
        n -= 2;
        m -= 2;
        calculate(n, m);
    }
}
