package main.java.com.poogle.PG.Q76502;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }
    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String first = s.substring(0, 1);
            String last = s.substring(1);
            s = last + first;
            if (check(s)) {
                answer += 1;
            }
        }
        return answer;
    }

    private static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
