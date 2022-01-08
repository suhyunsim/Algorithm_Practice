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

    public int[] solutionTwo(int[] answers) {
        int[] answer = {};
        int[] pOne = {1, 2, 3, 4, 5};
        int[] pTwo = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pThree = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int aOne = 0, aTwo = 0, aThree = 0;

        for (int i = 0; i < answers.length; i++) {
            if (pOne[i % pOne.length] == answers[i]) aOne++;
            if (pTwo[i % pTwo.length] == answers[i]) aTwo++;
            if (pThree[i % pThree.length] == answers[i]) aThree++;
        }
        int max = Math.max(Math.max(aOne, aTwo), aThree);
        ArrayList<Integer> list = new ArrayList<>();
        if (max == aOne) list.add(1);
        if (max == aTwo) list.add(2);
        if (max == aThree) list.add(3);

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
