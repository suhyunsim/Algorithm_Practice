package main.java.com.poogle.PG.Q12915;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    static String[] solution(String[] strings, int n) {
        List<Dictionary> list = new ArrayList<>();
        for (String string : strings) {
            list.add(new Dictionary(string.charAt(n), string));
        }
        Collections.sort(list);
        String[] answer = new String[strings.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).string;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"sun", "bed", "car"};
        System.out.println(Arrays.toString(solution(arr, 1)));
    }

    private static class Dictionary implements Comparable<Dictionary> {
        Character s;
        String string;

        public Dictionary(char s, String string) {
            this.s = s;
            this.string = string;
        }

        @Override
        public int compareTo(Dictionary dict) {
            if (this.s > dict.s) {
                return 1;
            } else if (this.s == dict.s) {
                return this.string.compareTo(dict.string);
            }
            return -1;
        }
    }
}
