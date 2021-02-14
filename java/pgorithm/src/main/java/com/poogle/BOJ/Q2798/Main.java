package main.java.com.poogle.BOJ.Q2798;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int number = sc.nextInt();
        int[] cards = new int[size];
        for (int i = 0; i < size; i++) {
            cards[i] = sc.nextInt();
        }
        int result = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= number) {
                        if (result <= sum) {
                            result = sum;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
