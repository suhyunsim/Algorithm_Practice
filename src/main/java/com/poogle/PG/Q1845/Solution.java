package main.java.com.poogle.PG.Q1845;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed().distinct().collect(Collectors.toList());
        return Math.min(list.size(), nums.length / 2);
    }
}
