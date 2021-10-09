package main.java.com.poogle.BOJ.Q16198;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(go(list));
    }

    private static int go(List<Integer> list) {
        int k = list.size();
        if (k == 2) return 0;
        int ans = 0;
        for (int i = 1;  i < k - 1; i++) {
            int energy = list.get(i - 1) * list.get(i + 1);
            List<Integer> left = new ArrayList<>(list);
            left.remove(i);
            energy += go(left);
            if (ans < energy) {
                ans = energy;
            }
        }
        return ans;
    }
}
