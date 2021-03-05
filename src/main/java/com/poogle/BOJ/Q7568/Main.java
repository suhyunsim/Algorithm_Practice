package main.java.com.poogle.BOJ.Q7568;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        int[] grade = new int[N];

        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (x[i] > x[j] && y[i] > y[j]) {
                    grade[j]++;
                    continue;
                }
                if (x[i] < x[j] && y[i] < y[j]) {
                    grade[i]++;
                    continue;
                }
            }
        }
        for (int n : grade) {
            System.out.print(n + 1);
            System.out.print(" ");
        }
    }
}
