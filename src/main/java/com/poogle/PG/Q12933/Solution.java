package main.java.com.poogle.PG.Q12933;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static long solution(long n) {
        List<Integer> list = new ArrayList<>();
        StringBuilder answer= new StringBuilder();
        while (n > 0) {
            list.add((int) (n % 10));
            n /= 10;
        }
        list.sort(Comparator.reverseOrder());
        for (Integer i : list) {
            answer.append(i);
        }
        return Long.parseLong(String.valueOf(answer));
    }

    public static void main(String[] args) {
        System.out.println(solution(100124));
    }
}
