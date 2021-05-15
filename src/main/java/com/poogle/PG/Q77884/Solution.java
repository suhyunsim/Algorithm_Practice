package main.java.com.poogle.PG.Q77884;

public class Solution {
    public static void main(String[] args) {
        int ans = solution(24, 27);
        System.out.println(ans);
    }

    public static int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i < right + 1; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            System.out.println("i: "+ i + "cnt: " + cnt);
            if (cnt % 2 != 0) {
                System.out.println("-" + i);
                answer -= i;
            } else {
                System.out.println("+" + i);
                answer += i;
            }
        }
        return answer;
    }
}
