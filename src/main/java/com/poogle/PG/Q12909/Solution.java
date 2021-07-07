package main.java.com.poogle.PG.Q12909;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) != '(') return false;
        else stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            if (stack.isEmpty()) {
                if (s.charAt(i) == ')') return false;
                else stack.push('(');
            } else {
                if (stack.peek() == '(') {
                    if (s.charAt(i) == ')') stack.pop();
                    else stack.push('(');
                }
            }
            i++;
        }

        return stack.isEmpty();
    }
}
