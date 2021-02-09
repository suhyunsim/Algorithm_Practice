package main.java.com.poogle.BOJ.Q2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        int mul = (a * b * c);
        int[] arr = new int[10];
        while (mul > 0) {
            arr[mul % 10]++;
            mul /= 10;
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
