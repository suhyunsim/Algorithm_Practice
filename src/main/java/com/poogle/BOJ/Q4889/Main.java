package main.java.com.poogle.BOJ.Q4889;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (true) {
            String s = sc.next();
            if (s.startsWith("-")) break;
            System.out.println(i++ + ". " + check(s));
        }
    }

    private static int check(String input) {
        int cnt = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '{') {
                if (stack.peek() == '{') {
                    cnt++;
                } else {
                    cnt += 2;
                }
            } else {
                cnt++;
            }
            stack.pop();
        }
        return cnt;
    }

}
