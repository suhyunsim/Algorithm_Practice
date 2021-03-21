package main.java.com.poogle.BOJ.Q9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            boolean flag = true;
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.pop() == '(') {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty() || !flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        br.close();
    }
}
