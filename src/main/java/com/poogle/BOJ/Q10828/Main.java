package main.java.com.poogle.BOJ.Q10828;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    stack.push(command[1]);
                    break;
                case "pop":
                    if (!stack.isEmpty()) {
                        System.out.println(stack.pop());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if (!stack.isEmpty()) {
                        System.out.println(stack.peek());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                default:
                    break;
            }
        }
        br.close();
    }
}
