package main.java.com.poogle.cracking.Ch1ArrayString.Q3;

import java.util.Stack;

public class SolutionA {
    /*
    Write a method to replace all spaces in a string with '%20'.
    You may assume that the string has sufficient space at the end to hold the additional characters,
    and that you are given the "true" length of the string.
    (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
     */
    public static void main(String[] args) {
        System.out.println(solution("Mr John Smith     ", 13));
        System.out.println(solution("   Mr John Smith hel", 13));
    }

    private static final String CODE = "%20";

    private static String solution(String line, int cnt) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            // 1-1. If character -> copy, if before character is %20 -> pop
            if (line.charAt(i) != ' ') {
                sb.append(line.charAt(i));
                if (!stack.isEmpty()) stack.pop();
            // 1-2. If space -> put %20, and check not to duplicate
            } else {
                if (stack.isEmpty()) {
                    sb.append(CODE);
                } else {
                    stack.pop();
                }
                stack.push(' ');
            }
        }
        String answer = sb.toString();
        // 2. If there are first & last %20 -> delete
        if (sb.substring(sb.length() - 3, sb.length()).equals("%20")) {
            answer = sb.substring(0, sb.length() - 3);
        }
        if (sb.substring(0, 3).equals("%20")) {
            answer = answer.substring(3);
        }
        return answer;
    }

}
