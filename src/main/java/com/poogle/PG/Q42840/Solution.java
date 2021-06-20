package main.java.com.poogle.PG.Q42840;

import java.util.*;

public class Solution {
    public static int[] solution(int[] answers) {
        Queue<Integer> qOne = new LinkedList<>();
        Queue<Integer> qTwo = new LinkedList<>();
        Queue<Integer> qThree = new LinkedList<>();
        int[] lOne = {1, 2, 3, 4, 5};
        int[] lTwo = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] lThree = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int k : lOne) {
            qOne.add(k);
        }
        for (int k : lTwo) {
            qTwo.add(k);
        }
        for (int k : lThree) {
            qThree.add(k);
        }
        int cntOne = 0;
        int cntTwo = 0;
        int cntThree = 0;
        for (int j : answers) {
            if (j == qOne.peek()) {
                cntOne++;
            }
            if (j == qTwo.peek()) {
                cntTwo++;
            }
            if (j == qThree.peek()) {
                cntThree++;
            }
            qOne.offer(qOne.poll());
            qTwo.offer(qTwo.poll());
            qThree.offer(qThree.poll());
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(1, cntOne);
        cnt.put(2, cntTwo);
        cnt.put(3, cntThree);
        int maxValue = Collections.max(cnt.values());
        ArrayList<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, Integer> c : cnt.entrySet()) {
            if (c.getValue() == maxValue) {
                answer.add(c.getKey());
            }
        }
        return answer.stream().filter(Objects::nonNull).mapToInt(i -> i).toArray();
    }
}
