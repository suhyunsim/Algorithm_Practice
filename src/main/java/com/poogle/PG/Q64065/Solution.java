package main.java.com.poogle.PG.Q64065;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))); //2134
//        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))); //2134
//        System.out.println(Arrays.toString(solution("{{20,111},{111}}"))); //111 20
//        System.out.println(Arrays.toString(solution("{{123}}")));
//        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))); //3241
        System.out.println(Arrays.toString(solutionTwo("{{4,2,3},{3},{2,3,4,1},{2,3}}"))); //3241
    }

    private static int[] solution(String s) {
        List<Integer> ans = new ArrayList<>();
        String str = s.substring(1, s.length() - 1).replaceAll("[{}]", "");
        int[] strArr = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> list = new LinkedHashMap<>();
        for (int j : strArr) {
            if (list.containsKey(j)) {
                list.replace(j, list.get(j) + 1);
            } else {
                list.put(j, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entries = list.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> entry : entries) {
            ans.add(entry.getKey());
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private static int[] solutionTwo(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int index = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) answer[index++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

}
