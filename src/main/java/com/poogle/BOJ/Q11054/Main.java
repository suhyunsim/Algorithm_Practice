package main.java.com.poogle.BOJ.Q11054;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] dI = new int[n];
        for (int i = 0; i < n; i++) {
            dI[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dI[i] < dI[j] + 1) {
                    dI[i] = dI[j] + 1;
                }
            }
        }
        int[] dD = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dD[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i] && dD[i] < dD[j] + 1) {
                    dD[i] = dD[j] + 1;
                }
            }
        }
        int ans = dI[0] + dD[0] - 1;
        for (int i = 0; i < n; i++) {
            if (ans < dI[i] + dD[i] - 1) {
                ans = dI[i] + dD[i] - 1;
            }
        }
        System.out.println(ans);
    }
}
