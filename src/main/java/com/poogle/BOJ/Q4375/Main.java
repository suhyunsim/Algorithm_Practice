package main.java.com.poogle.BOJ.Q4375;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int num = 0;
            for (int i = 1; ; i++) { //조건식 생략 -> 무한 루프
                num = num * 10 + 1; //num에는 항상 이전 나머지가 들어있음
                num %= n;
                if (num == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }
}
