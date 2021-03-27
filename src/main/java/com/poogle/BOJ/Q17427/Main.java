package main.java.com.poogle.BOJ.Q17427;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0; //타입 확인
        for (int i = 1; i <= n; i++) {
            ans += (n / i) * i; //(n / i)는 i의 배수의 개
        }
        System.out.println(ans);
        sc.close();
    }
}
