package main.java.com.poogle.BOJ.Q1874;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> result = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            while (cnt <= num) {
                stack.push(cnt);
                cnt += 1;
                result.add('+');
            }
            if (stack.peek() == num) {
                stack.pop();
                result.add('-');
            } else {
                System.out.println("NO");
                return;
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        sc.close();
    }
}
