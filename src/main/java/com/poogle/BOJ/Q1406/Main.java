package main.java.com.poogle.BOJ.Q1406;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        int m = Integer.parseInt(br.readLine());

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (String s : str) {
            left.push(s);
        }


        while (m-- > 0) {
            char[] input = br.readLine().toCharArray();
            switch (input[0]) {
                case 'L':
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case 'P':
                    left.push(String.valueOf(input[2]));
                    break;
                default:
                    break;
            }
        }
        while (!left.isEmpty())
            right.push(left.pop());
        while (!right.isEmpty())
            bw.write(right.pop());
        bw.flush();
        bw.close();
    }
}
