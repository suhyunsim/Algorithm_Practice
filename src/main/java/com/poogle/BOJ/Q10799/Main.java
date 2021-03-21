package main.java.com.poogle.BOJ.Q10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String list = br.readLine();
        int cnt = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < list.length(); i++) {
            if (list.charAt(i) == '(') {
                stack.push(list.charAt(i));
            } else if (list.charAt(i) == ')') {
                stack.pop();
                if (list.charAt(i - 1) == '(')
                    cnt += stack.size();
                else
                    cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
