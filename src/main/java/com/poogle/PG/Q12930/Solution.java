package main.java.com.poogle.PG.Q12930;

import java.util.Arrays;

public class Solution {
    public static String solution(String s) {
        StringBuilder ans = new StringBuilder();
        String[] list = s.split("");
        System.out.println(Arrays.toString(list));
        int cnt = 0;
        for (String w : list) {
            cnt = w.contains(" ") ? 0 : cnt + 1;
            ans.append(cnt % 2 == 0 ? w.toLowerCase() : w.toUpperCase());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
        System.out.println(solution("What"));
        System.out.println(solution("why it doesn't work oh my god"));
        System.out.println(solution("         "));
    }
}
