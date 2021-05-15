package main.java.com.poogle.PG.Q77885;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        long[] ans = solution(new long[]{2, 7});
        System.out.println(Arrays.toString(ans));
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = findClosest(numbers[i]);
        }
        return answer;
    }

    private static long findClosest(long number) {
        String origin = Long.toBinaryString(number);
        if (origin.charAt(origin.length() - 1) == '0') {
            return number + 1;
        } else {
            int i = 0;
            for (i = origin.length() - 1; i >= 0; i--) {
                if (origin.charAt(i) == '0') {
                    break;
                }
            }
            String next;
            if (i == -1) {
                //모두 1인 경우
                next = "10" + origin.substring(1);
            } else {
                //0이 하나라도 있는 경우
                next = origin.substring(0, i) + "10" + origin.substring(i + 2);
            }
            return Long.parseLong(next, 2);
        }
    }
}
