package main.java.com.poogle.BOJ.Q10973;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (prevPermutation(a)) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }

    private static boolean prevPermutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] <= a[i]) { //다음 수열문제와 등호 다름
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length - 1;
        while (a[j] >= a[i - 1]) {//다음 수열 문제와 등호 다름
            j -= 1;
        }
        int tmp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = tmp;

        j = a.length - 1;
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
