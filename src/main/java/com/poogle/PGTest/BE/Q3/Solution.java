package main.java.com.poogle.PGTest.BE.Q3;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
//        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
//        System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }

    private static int solution(int n, int[][] wires) {
        int[] cnt = new int[n + 1];
        for (int i = 0; i < wires.length; i++) {
            cnt[wires[i][0]] += 1;
            cnt[wires[i][1]] += 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, cnt[i]);
        }
        System.out.println(map);
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (val1, val2) -> (map.get(val2).compareTo(map.get(val1))));
        for (int i = 0; i < 2; i++) {
            int val = map.get(keyList.get(i));
            map.put(keyList.get(i), val - 1);
        }
        System.out.println(map);

        return 0;
    }
}
