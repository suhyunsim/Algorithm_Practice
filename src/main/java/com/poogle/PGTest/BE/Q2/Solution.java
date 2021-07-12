package main.java.com.poogle.PGTest.BE.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static int[] solution(int[] deposit) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < deposit.length; i++) {
            if (deposit[i] >= 0) {
                stack.push(deposit[i]);
            } else {
                int now = stack.peek();
                if (now >= Math.abs(deposit[i])) {
                    stack.push(stack.pop() + deposit[i]);
                } else {
                    deposit[i] += now;
                    stack.pop();
                    int current = stack.pop();
                    while (current < Math.abs(deposit[i])) {
                        current += stack.pop();
                    }
                    if (current >= Math.abs(deposit[i])) {
                        stack.push(current + deposit[i]);
                    }
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i : stack) {
            if (i != 0) {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{500, 1000, -300, 200, -400, 100, -100})));
        System.out.println(Arrays.toString(solution(new int[]{500, 1000, 2000, -1000, -1500, 500})));
        System.out.println(Arrays.toString(solution(new int[]{500, 500, -700, -200, 100, -100})));
        System.out.println(Arrays.toString(solution(new int[]{500, -500, 100})));

    }
}
