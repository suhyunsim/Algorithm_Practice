package main.java.com.poogle.PG.Q17681;

import java.util.Arrays;

public class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            //앞에 채워서 최대 5자로 만들기 (문자열 형식 %s에 개수 n을 붙인 상태)
            str = String.format("%" + n + "s", str);
            str = str.replaceAll("1", "#");
            str = str.replaceAll("0", " ");
            answer[i] = str;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{1, 20, 28, 18, 11}, new int[]{2, 1, 21, 17, 28})));
    }
}
