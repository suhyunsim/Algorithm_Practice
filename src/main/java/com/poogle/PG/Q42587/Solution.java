package main.java.com.poogle.PG.Q42587;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
    }

    private static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Printer(i, priorities[i]));
        }
        while (!queue.isEmpty()) {
            boolean flag = false;
            int now = queue.peek().prior;
            for (Printer p : queue) {
                if (now < p.prior) flag = true;
            }
            if (flag) {
                queue.offer(queue.poll());
            } else {
                if (queue.poll().location == location) {
                    answer = priorities.length - queue.size();
                }
            }
        }
        return answer;
    }

    static class Printer {
        int location;
        int prior;

        public Printer(int location, int prior) {
            this.location = location;
            this.prior = prior;
        }
    }
}
