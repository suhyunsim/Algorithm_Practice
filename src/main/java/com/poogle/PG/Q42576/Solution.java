package main.java.com.poogle.PG.Q42576;

import java.util.Arrays;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int playerIndex = 0;

        for (playerIndex = 0; playerIndex < completion.length; playerIndex++) {

            if (!participant[playerIndex].equals(completion[playerIndex])) {
                return participant[playerIndex];
            }
        }
        return participant[playerIndex];
    }
}
