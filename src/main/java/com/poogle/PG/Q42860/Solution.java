package main.java.com.poogle.PG.Q42860;

public class Solution {
    public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
            int index = i + 1;
            while (index < len && name.charAt(index) == 'A') index++;

            min = Math.min(i * 2 + (len - index), min);
            min = Math.min(i + 2 * (len - index), min);
        }
        return answer + min;
    }

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
    }
}
