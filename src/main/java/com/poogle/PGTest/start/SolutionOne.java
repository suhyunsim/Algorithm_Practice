package main.java.com.poogle.PGTest.start;

import java.util.*;

//lv1 2
class SolutionOne {
    public static int[] solution(String code, String day, String[] data) {
        int[] answer = {};
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (String datum : data) {
            String[] info = datum.split(" ");
            String dayString = info[2].substring(5);
            System.out.println(dayString);
            if (code.equals(info[1].substring(5, 11)) && day.equals(dayString.substring(0, 8))) {
                map.put(Integer.parseInt(dayString.substring(dayString.length() - 2)), Integer.parseInt(info[0].substring(6)));
            }
        }
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());

        entries.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Integer, Integer> entry : entries) {
            list.add(entry.getValue());
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        String code = "012345";
        String day = "20190620";
        String[] data = {"price=80 code=987654 time=2019062113", "price=90 code=012345 time=2019062014", "price=120 code=987654 time=2019062010", "price=110 code=012345 time=2019062009", "price=95 code=012345 time=2019062111"};
        solution(code, day, data);

    }
}
