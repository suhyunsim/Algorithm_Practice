package main.java.com.poogle.PG.Q42842;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
    }

    private static int[] solution(int brown, int yellow) {
        int n = brown + yellow;
        int [] answer = new int[2];
        for (int i = 3; i <= n; i++) {
            if (n % i == 0) {
                if ((i - 2) * ((n / i) - 2) == yellow) {
                    if (i > n / i) {
                        answer[0] = i;
                        answer[1] = n / i;
                    } else {
                        answer[0] = n / i;
                        answer[1] = i;
                    }
                }
            }
        }

        return answer;
    }
}
