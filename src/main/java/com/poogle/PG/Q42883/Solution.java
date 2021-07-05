package main.java.com.poogle.PG.Q42883;

import java.util.Stack;

public class Solution {
    public static String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
}
