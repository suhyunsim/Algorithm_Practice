package main.java.com.poogle.BOJ.Q1475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[10];
        while (n > 0) {
            numbers[n % 10] += 1;
            n /= 10;
        }

        int dup = numbers[6] + numbers[9];

        if ((numbers[6] + numbers[9]) % 2 == 1) {
            numbers[6] = dup / 2 + 1;
            numbers[9] = dup / 2 + 1;
        } else {
            numbers[6] = dup / 2;
            numbers[9] = dup / 2;
        }
        int max = 1;
        for (int i : numbers) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}
