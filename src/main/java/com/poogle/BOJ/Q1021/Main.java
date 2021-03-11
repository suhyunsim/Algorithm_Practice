package main.java.com.poogle.BOJ.Q1021;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag;
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int cnt = 0;
        int m = sc.nextInt();
        while (m-- > 0) {
            int num = sc.nextInt();
            flag = false;
            while (!flag) {
                if (list.get(0) == num) {
                    list.remove(0);
                    flag = true;
                } else {
                    if (list.indexOf(num) <= list.size() / 2) {
                        list.add(list.size() - 1, list.remove(0)); // 앞에서 빼기
                    } else {
                        list.add(0, list.remove(list.size() - 1)); // 뒤에서 빼기
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
