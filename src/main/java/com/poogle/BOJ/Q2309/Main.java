package main.java.com.poogle.BOJ.Q2309;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = 9;
        int total = 0;
        while (n-- > 0) {
            int a = sc.nextInt();
            list.add(a);
            total += a;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (total - (list.get(i) + list.get(j)) == 100) {
                    list.remove(list.get(j));
                    list.remove(list.get(i));
                }
            }
        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        sc.close();
    }
}
