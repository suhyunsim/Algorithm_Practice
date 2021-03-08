package main.java.com.poogle.BOJ.Q5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '<') {
                    if (!left.isEmpty()) right.push(left.pop());
                } else if (input.charAt(i) == '>') {
                    if (!right.isEmpty()) left.push(right.pop());
                } else if (input.charAt(i) == '-') {
                    if (!left.isEmpty()) left.pop();
                } else {
                    left.push(input.charAt(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            System.out.println(sb.toString());
        }
    }
}
