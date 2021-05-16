package main.java.com.poogle.BOJ.Q15654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] a = new int[10];
    static int[] num = new int[10];
    static boolean[] c = new boolean[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //N과 M(1)과 똑같은데 num[]만 다름
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        //정렬 필요
        Arrays.sort(num, 0, n);
        System.out.println(go(0, n, m));
    }

    private static StringBuilder go(int index, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(num[a[i]]);
                if (i != m - 1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            ans.append(go(index + 1, n, m));
            c[i] = false;
        }
        return ans;
    }
}
