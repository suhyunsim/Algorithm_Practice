package main.java.com.poogle.PG.Q92334;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
        System.out.println(Arrays.toString(solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        Map<String, Integer> reportMap = new HashMap<>();
        Map<String, Set<String>> reportList = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for (String id : id_list) {
            reportMap.put(id, 0);
            reportList.put(id, new HashSet<>());
            result.put(id, 0);
        }
        for (String rp : reportSet) {
            String[] list = rp.split(" ");
            reportList.get(list[0]).add(list[1]);
            reportMap.put(list[1], reportMap.get(list[1]) + 1);
        }

        List<String> reportedList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            if (entry.getValue() >= k) {
                reportedList.add(entry.getKey());
            }
        }
        for (Map.Entry<String, Set<String>> entry : reportList.entrySet()) {
            Set<String> findList = entry.getValue();
            for (String s : reportedList) {
                if (findList.contains(s)) {
                    result.put(entry.getKey(), result.get(entry.getKey()) + 1);
                }
            }
        }
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = result.get(id_list[i]);
        }
        return answer;
    }
}
