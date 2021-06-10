package main.java.com.poogle.BOJ.Q10974;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        do {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } while (nextPermutation(a));
    }

    private static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }
        int tmp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = tmp;

        j = a.length -1;
        while (i < j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
