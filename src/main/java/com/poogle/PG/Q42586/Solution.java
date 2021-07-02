package main.java.com.poogle.PG.Q42586;

import java.util.*;

public class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int d = (100 - progresses[i]) / speeds[i];
            if (d * speeds[i] + progresses[i] == 100) {
                queue.offer(d);
            } else {
                queue.offer(d + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cnt = 1;
            int q1 = queue.poll();
            while (!queue.isEmpty() && queue.peek() <= q1) {
                cnt++;
                queue.poll();
            }
            list.add(cnt);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }
}
