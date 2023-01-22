package main.java.com.poogle.CD.L1.BinaryGap;

import java.util.Stack;

class Solution {
    public int solution(int N) {
        Stack<Integer> binaryList = new Stack<>();
        while (N > 0) {
            int num = N % 2;
            N /= 2;
            binaryList.push(num);
        }

        int max = 0;
        while (!binaryList.isEmpty()) {
            boolean flag = false;
            if (binaryList.peek() == 1) {
                binaryList.pop();
                int now = 0;
                while (!binaryList.isEmpty()) {
                    if (binaryList.peek() == 1) {
                        flag = true;
                        break;
                    }
                    binaryList.pop();
                    now++;
                }
                if (now > max && flag)
                    max = now;
            } else {
                binaryList.pop();
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
