package main.java.com.poogle.PG.Q60057;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        int answer = s.length();
        int cnt = 1;
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder result = new StringBuilder();
            String now = s.substring(0, i);
            for (int j = i; j <= s.length(); j += i) {
                int endInx = Math.min(j + i, s.length());
                String next = s.substring(j, endInx);
                if (now.equals(next)) {
                    cnt++;
                } else {
                    if (cnt >= 2) result.append(cnt);
                    result.append(now);
                    now = next;
                    cnt = 1;
                }
            }
            result.append(now);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}
