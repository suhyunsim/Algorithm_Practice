package main.java.com.poogle.PG.Q118666;

import java.util.Arrays;

public class Solution {
    private static final String[] INDICATORS = {"RT", "CF", "JM", "AN"};
    public static String solution(String[] survey, int[] choices) {
        int[] cnt = new int['Z' - 'A' + 1];
        for (int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            int score = choices[i] - 4;
            if (score == 0)
                continue;
            if (score < 0)
                cnt[a - 'A'] -= score;
            else
                cnt[b - 'A'] += score;
        }
        System.out.println(Arrays.toString(cnt));
        StringBuilder sb = new StringBuilder();
        for (String indicator : INDICATORS) {
            char a = indicator.charAt(0);
            char b = indicator.charAt(1);
            int cntA = cnt[a - 'A'];
            int cntB = cnt[b - 'A'];
            if (cntA == cntB)
                sb.append(a);
            else
                sb.append(cntA > cntB ? a : b);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }
}
