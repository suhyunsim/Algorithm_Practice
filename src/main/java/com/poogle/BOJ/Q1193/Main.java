package main.java.com.poogle.BOJ.Q1193;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int sum = 0;
        int i = 1;
        while (true) {
            if (x <= sum + i) {
                if (i % 2 == 1) {
                    System.out.println(i - (x - sum - 1) + "/" + (x - sum));
                } else {
                    System.out.println((x - sum) + "/" + (i - (x - sum - 1)));
                }
                break;
            } else {
                sum += i++;
            }
        }
    }
}
