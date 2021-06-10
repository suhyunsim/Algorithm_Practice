package main.java.com.poogle.BOJ.Q10972;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (nextPermutation(a)) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }

    private static boolean nextPermutation(int[] a) { //다음 순열 있는지 판단
        int i = a.length - 1;
        //i찾기
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }

        //j찾기
        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        //swap
        int tmp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = tmp;

        //a[i]부터 순열 뒤집기
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
