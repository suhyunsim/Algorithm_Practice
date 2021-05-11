package main.java.com.poogle.PG.Q77484;

import java.util.HashSet;
import java.util.Set;

//로또의 최고 순위와 최저 순위
public class Solution {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int winCnt = 0;
        int zeroCnt = 0;

        int[] level = {6, 6, 5, 4, 3, 2, 1};
        Set<Integer> set = new HashSet<>();

        for (int i : win_nums) {
            set.add(i);
        }
        for (int i : lottos) {
            if (i == 0) zeroCnt++;
            if (set.contains(i)) winCnt++;
        }
        return new int[] {level[winCnt + zeroCnt], level[winCnt]};
    }

    public static void main(String[] args) {
        int[] lottos = {5, 2, 0, 0, 4};
        int[] win_nums = {1, 4, 2, 5, 3};
        solution(lottos, win_nums);
    }
}
