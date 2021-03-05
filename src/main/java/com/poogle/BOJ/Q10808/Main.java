package main.java.com.poogle.BOJ.Q10808;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 97]++;
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
