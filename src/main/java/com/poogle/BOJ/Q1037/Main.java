package main.java.com.poogle.BOJ.Q1037;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(sc.nextInt());
        }
        System.out.println(Collections.max(list) * Collections.min(list));
        sc.close();
    }
}
