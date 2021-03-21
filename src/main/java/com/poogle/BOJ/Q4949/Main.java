package main.java.com.poogle.BOJ.Q4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '[' || c == '(') {
                    stack.push(c);
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.pop() == '[') continue;
                    else {
                        flag = false;
                        break;
                    }
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.pop() == '(') continue;
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (stack.isEmpty() && flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        br.close();
    }
}
