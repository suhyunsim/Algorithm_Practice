package main.java.com.poogle.PG.Q86051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
        System.out.println(solutionSum(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    }

    private static int solution(int[] numbers) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        List<Integer> nums = Arrays.stream(numbers).boxed().collect(Collectors.toList());
       for (int num : list) {
            if (!nums.contains(num)) {
                answer += num;
            }
        }
        return answer;
    }

    private static int solutionSum(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }

}
