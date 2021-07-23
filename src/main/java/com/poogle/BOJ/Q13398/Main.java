package main.java.com.poogle.BOJ.Q13398;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dL = new int[n];
        int[] dR = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dL[i] = a[i];
            if (i > 0 && dL[i] < dL[i - 1] + a[i]) {
                dL[i] = dL[i - 1] + a[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            dR[i] = a[i];
            if (i < n - 1 && dR[i] < dR[i + 1] + a[i]) {
                dR[i] = dR[i + 1] + a[i];
            }
        }
        int ans = dL[0];
        for (int i = 1; i < n; i++) {
            if (ans < dL[i]) {
                ans = dL[i];
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (ans < dL[i - 1] + dR[i + 1]) {
                ans = dL[i - 1] + dR[i + 1];
            }
        }
        System.out.println(ans);
    }
}
