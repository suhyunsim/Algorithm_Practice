package main.java.com.poogle.PG.Q12917;

import java.util.Arrays;

public class Solution {
    public static String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new StringBuilder(new String(arr)).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("Zbcdegf"));
    }
}
