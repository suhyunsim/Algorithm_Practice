package main.java.com.poogle.PG.Q64061;

import java.util.Stack;

public class Solution {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < moves.length; i++) {
            int k = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                int n = board[j][k];
                if (n != 0) {
                    if (!stack.isEmpty() && stack.peek() == n) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(n);
                    }
                    board[j][k] = 0;
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }
}
