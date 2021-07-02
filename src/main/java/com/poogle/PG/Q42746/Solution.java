package main.java.com.poogle.PG.Q42746;

import java.util.Arrays;

public class Solution {
    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] sNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(Arrays.toString(sNumbers));
        Arrays.sort(sNumbers, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        System.out.println(Arrays.toString(sNumbers));
        if (sNumbers[0].equals("0")) return "0";
        for (String n : sNumbers) answer.append(n);
        return answer.toString();
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 12, 121, 122}));
//        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println();
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
}
