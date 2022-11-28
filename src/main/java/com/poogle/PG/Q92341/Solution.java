package main.java.com.poogle.PG.Q92341;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    static Map<String, Long> answer;

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        Map<String, Date> map = new HashMap<>();
        answer = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        for (String record : records) {
            String[] result = record.split(" ");
            String key = result[1];
            if (result[2].equals("IN")) {
                Date inTime = format.parse(result[0]);
                map.put(key, inTime);
            } else {
                Date inTime = map.get(key);
                Date outTime = format.parse(result[0]);
                long diffMinutes = cntMinutes(outTime, inTime);
                checkKey(key, diffMinutes);
                map.remove(key);
            }
        }
        for (String key : map.keySet()) {
            Date inTime = map.get(key);
            Date lastTime = format.parse("23:59");
            long diffMinutes = cntMinutes(lastTime, inTime);
            checkKey(key, diffMinutes);
        }

        int[] answerArr = new int[answer.size()];
        int i = 0;
        List<String> keyList = new ArrayList<>(answer.keySet());
        Collections.sort(keyList);
        for (String key : keyList) {
            if (answer.get(key) <= fees[0]) {
                answerArr[i] = fees[1];
            } else {
                int used;
                if ((answer.get(key) - fees[0]) % fees[2] > 0) {
                    used = (int) (answer.get(key) - fees[0]) / fees[2] + 1;
                } else {
                    used = (int) (answer.get(key) - fees[0]) / fees[2];
                }
                answerArr[i] = fees[1] + used * fees[3];
            }
            i++;
        }
        return answerArr;
    }

    private static void checkKey(String key, long diffMinutes) {
        if (answer.containsKey(key)) {
            answer.put(key, answer.get(key) + diffMinutes);
        } else {
            answer.put(key, diffMinutes);
        }
    }

    private static long cntMinutes(Date date1, Date date2) {
        return (date1.getTime() - date2.getTime()) / (60 * 1000);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
        System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591},
                new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"})));
        System.out.println(Arrays.toString(solution(new int[]{1, 461, 1, 10},
                new String[]{"00:00 1234 IN"})));
    }
}
