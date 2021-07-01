package main.java.com.poogle.PG.Q42626;

import java.util.PriorityQueue;

public class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : scoville) {
            heap.offer(i);
        }
        while (heap.peek() < K) {
            System.out.println(heap);
            if (heap.size() < 2) return -1;
            int f1 = heap.poll();
            System.out.println("f1: " + f1);
            int f2 = heap.poll();
            System.out.println("f2: " + f2);
            int newFood = f1 + f2 * 2;
            heap.offer(newFood);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6}, 10));
//        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1}, 27));
    }
}
