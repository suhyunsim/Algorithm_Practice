package main.java.com.poogle.PG.Q42748;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int t = 0; t < commands.length; t++) {
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            ArrayList<Integer> newArray = new ArrayList<>();
            for (int f = i; f <= j; f++) {
                newArray.add(array[f - 1]);
            }
            Collections.sort(newArray);
            answer[t] = newArray.get(k - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }
}
