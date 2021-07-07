package main.java.com.poogle.PG.Q42885;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
    }

    private static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0;
        int answer = 0;
        for (int max = people.length - 1; min <= max; max--) {
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }
        return answer;
    }
}
