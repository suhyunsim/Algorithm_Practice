package main.java.com.poogle.PG.Q12949;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        Queue<Integer> queue = new LinkedList<>();
        for (int j = 0; j < arr2[0].length; j++) {
            for (int i = 0; i < arr2.length; i++) {
                queue.offer(arr2[i][j]);
            }
        }
        Queue<Integer> nums = new LinkedList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr2[0].length; k++) {
                int n = 0;
                for (int j = 0; j < arr1[0].length; j++) {
                    n += arr1[i][j] * queue.peek();
                    queue.offer(queue.poll());
                }
                nums.add(n);
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                answer[i][j] = nums.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4}, {2, 4}, {3, 1}})));
    }
}
