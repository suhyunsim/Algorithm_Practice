package main.java.com.poogle.PG.Q12953;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = 1;
        for (int j : arr) {
            answer = lcm(answer, j);
        }
        return answer;
    }

    private static int lcm(int x, int y) {
        return ((x * y) / gcd(x, y));
    }

    private static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
    }
}
