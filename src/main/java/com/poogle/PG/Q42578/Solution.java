package main.java.com.poogle.PG.Q42578;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Solution {

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            clothMap.put(clothes[i][1], clothMap.getOrDefault(clothes[i][1], 0) + 1);
        }

        Set<String> keySet = clothMap.keySet();
        for (String key : keySet) {
            answer *= clothMap.get(key) + 1;
        }
        return answer - 1;
    }

    public static int solutionStream(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solutionStream(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}
