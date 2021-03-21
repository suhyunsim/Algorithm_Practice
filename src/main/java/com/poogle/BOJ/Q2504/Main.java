package main.java.com.poogle.BOJ.Q2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int cnt = 1;
        int result = 0;
        String line = br.readLine();
        if (line.length() % 2 == 1) { //괄호 짝 안 맞으면 0 출력
            System.out.println(0);
            return;
        }
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push(line.charAt(i));
                cnt *= 2;
            } else if (line.charAt(i) == '[') {
                stack.push(line.charAt(i));
                cnt *= 3;
            } else if (line.charAt(i) == ')') {
                if (stack.isEmpty() || !stack.peek().equals('(')) {
                    System.out.println(0);
                    return;
                }
                if (line.charAt(i - 1) == '(')
                    result += cnt;
                stack.pop();
                cnt /= 2;
            } else if (line.charAt(i) == ']') {
                if (stack.isEmpty() || !stack.peek().equals('[')) {
                    System.out.println(0);
                    return;
                }
                if (line.charAt(i - 1) == '[')
                    result += cnt;
                stack.pop();
                cnt /= 3;
            }
        }
        System.out.println(result);
        br.close();
    }
}
