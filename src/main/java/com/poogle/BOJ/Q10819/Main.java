package main.java.com.poogle.BOJ.Q10819;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a); //첫 순열: 오름차순 정렬
        int ans = 0;
        do {
            int tmp = calculate(a);
            ans = Math.max(ans, tmp);
        } while (nextPermutation(a));

        System.out.println(ans);
    }

    private static int calculate(int[] a) {
        int sum = 0;
        for (int i = 1; i < a.length; i++) {
            sum += Math.abs(a[i] - a[i - 1]);
        }
        return sum;
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
