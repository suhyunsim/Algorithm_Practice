package main.java.com.poogle.PG.Q42860;

public class Solution {
    public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int con = (c - 'A' < 'Z' - c + 1) ? (c - 'A') : ('Z' - c + 1);
            answer += con;

            int next = i + 1;
            //ì * 2 는 중간까지 왔다가 다시 뒤로 돌아갈 때의 조이스틱 이동 횟수이고,
            // len - nextIndex 는 A 연속 이후로 나오는 알파벳의 위치이다.
            while (next < len && name.charAt(next) == 'A') next++;
            min = Math.min(min, (i * 2) + len - next);
        }
        answer += min;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
    }
}
