package main.java.com.poogle.PGTest.BE.Q1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int[] d, int m) {
        Queue<Integer> queue = Arrays.stream(d).boxed().collect(Collectors.toCollection(LinkedList::new));
        int answer = 0;
        int i = 1;
        while (!queue.isEmpty()) {
            if (queue.poll() >= i) {
                m -= i;
                i *= 2;
            } else {
                i = 1;
            }
            answer++;
            if (m <= 0) return answer;
        }
        return m != 0 ? -1 : answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 5, 4}, 6));
        System.out.println(solution(new int[]{2, 2, 4, 3}, 6));
        System.out.println(solution(new int[]{2, 2, 4, 3}, 8));
    }
}
