package main.java.com.poogle.BOJ.Q15655;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] a = new int[10];
    static int[] num = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num, 0, n);
        /* 순서로 풀이
        System.out.println(go(0, 0, n, m));
         */
        System.out.println(go(0, 0, n, m));
    }

    /*
    순서로 풀이
    private static StringBuilder go(int index, int start, int n, int m) {
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
        for (int i = start; i < n; i++) {
            a[index] = i;
            ans.append(go(index + 1, i + 1, n, m));
        }
        return ans;
    }
*/
    //선택으로 풀이
    static StringBuilder go(int index, int selected, int n, int m) {
        if (selected == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(num[a[i]]);
                if (i != m - 1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        if (index >= n) return ans;
        a[selected] = index;
        ans.append(go(index + 1, selected + 1, n, m));
        a[selected] = 0;
        ans.append(go(index + 1, selected, n, m));
        return ans;
    }
}
