package main.java.com.poogle.BOJ.Q2920;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(sc.nextInt());
        }
        if (list.get(0) == 1) {
            for (int i = 0; i < 8; i++) {
                if (list.get(i) != i + 1) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
            return;
        }
        if (list.get(0) == 8) {
            for (int i = 0; i < 8; i++) {
                if (list.get(i) != 8 - i) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        } else System.out.println("mixed");
    }
}
