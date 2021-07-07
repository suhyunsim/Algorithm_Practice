package main.java.com.poogle.PG.Q12911;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    private static int solution(int n) {
        int cntN = Integer.bitCount(n);
        for (int i = n + 1; ; i++) {
            if (cntN == Integer.bitCount(i)) return i;
        }
    }
}
