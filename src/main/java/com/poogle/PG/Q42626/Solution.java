package main.java.com.poogle.PG.Q42626;

import java.util.PriorityQueue;

public class Solution {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }
        int answer = 0;
        while (pq.peek() < K) {
            int l1 = pq.poll();
            int l2 = pq.poll();
            int max = l1 + l2 * 2;
            if (pq.isEmpty() && max < K)
                return -1;
            pq.offer(max);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6}, 10));
        //        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1}, 27));
    }
}
