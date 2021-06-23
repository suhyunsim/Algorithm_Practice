package main.java.com.poogle.PG.Q12926;

public class Solution {
    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a != ' ') {
                if (a >= 'a' && a <= 'z') {
                    if (a + n > 'z') answer.append((char) (a + n - 26));
                    else answer.append((char) (a + n));
                } else if (a >= 'A' && a <= 'Z') {
                    if (a + n > 'Z') answer.append((char) (a + n - 26));
                    else answer.append((char) (a + n));
                }
            } else answer.append(' ');
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        System.out.println(solution("Z z a A", 50));
    }
}
