package main.java.com.poogle.cracking.Ch3StackQueue.Q5;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    public static void sort(Stack<Integer> stack1) {
        //stack1 -> stack2 in sorted order
        Stack<Integer> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            int temp = stack1.pop();
            while (!stack2.isEmpty() && stack2.peek() > temp) {
                stack1.push(stack2.pop());
            }
            stack2.push(temp);
        }
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public static Stack<Integer> mergeSort(Stack<Integer> inStack) {
        if (inStack.size() <= 1) {
            return inStack;
        }

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int cnt = 0;
        while (inStack.size() != 0) {
            cnt++;
            if (cnt % 2 == 0) {
                left.push(inStack.pop());
            } else {
                right.push(inStack.pop());
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() == 0) {
                inStack.push(right.pop());
            } else if (right.size() == 0) {
                inStack.push(left.pop());
            } else if (right.peek().compareTo(left.peek()) <= 0) {
                inStack.push(left.pop());
            } else {
                inStack.push(right.pop());
            }
        }
        Stack<Integer> reverseStack = new Stack<>();
        while (inStack.size() > 0) {
            reverseStack.push(inStack.pop());
        }
        return reverseStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        for (int i = 0; i < 10; i++) {
            int r = ThreadLocalRandom.current().nextInt(1, 1001);
            stack1.push(r);
        }
        sort(stack1);
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }
    }
}
