package main.java.com.poogle.PG.Q42889;

import java.util.*;

public class Solution {
    public static int[] solution(int N, int[] stages) {
        int[] trials = new int[N + 1];
        for (int stage : stages) {
            for (int j = 0; j < stage; j++) {
                trials[j]++;
            }
        }
        Map<Integer, Double> rates = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (trials[i] != 0) {
                rates.put(i + 1, ((trials[i] - trials[i + 1]) / (double) trials[i]));
            } else {
                //나누는 수가 0일 때는 0.0으로 넣어줘야 함
                rates.put(i + 1, 0.0);
            }
//            System.out.println("실패한 사람: " + (trials[i] - trials[i + 1]));
//            System.out.println("총 도전자: " + (double) trials[i]);
//            System.out.println("value: " + (trials[i] - trials[i + 1]) / (double) trials[i]);
        }
        List<Integer> keySet = new ArrayList<>(rates.keySet());
        //value값으로 key 정렬
        keySet.sort((val1, val2) -> rates.get(val2).compareTo(rates.get(val1)));
        return keySet.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 4, 2, 4, 3, 3})));
    }
}
