package main.java.com.poogle.BOJ.Q6603;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;
            int[] a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = sc.nextInt();
            }
            int[] d = new int[k];
            for (int i = 0; i < k; i++) {
                if (i < k - 6) d[i] = 0;
                else d[i] = 1;
            }
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            do {
                ArrayList<Integer> cur = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    if (d[i] == 1) {
                        cur.add(a[i]);
                    }
                }
                ans.add(cur);
            } while (nextPermutation(d));
            ans.sort((l1, l2) -> {
                int n = l1.size();
                int m = l2.size();
                int i = 0;
                while (i < n && i < m) {
                    int t1 = l1.get(i);
                    int t2 = l2.get(i);
                    if (t1 < t2) return -1;
                    else if (t1 > t2) return 1;
                    i += 1;
                }
                if (i == n && i != m) return -1;
                else if (i == m && i != n) return 1;
                return 0;
            });
            for (ArrayList<Integer> v : ans) {
                for (int x : v) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static boolean nextPermutation(int[] d) {
        int i = d.length - 1;
        while (i > 0 && d[i - 1] >= d[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = d.length - 1;
        while (d[j] <= d[i - 1]) {
            j -= 1;
        }
        int tmp = d[j];
        d[j] = d[i - 1];
        d[i - 1] = tmp;
        j = d.length - 1;
        while (i < j) {
            tmp = d[i];
            d[i] = d[j];
            d[j] = tmp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
