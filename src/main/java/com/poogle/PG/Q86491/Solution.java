package main.java.com.poogle.PG.Q86491;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
    }

    private static int solution(int[][] sizes) {
        int maxW = 0;
        int maxV = 0;
        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int v = Math.min(size[0], size[1]);
            maxW = Math.max(w, maxW);
            maxV = Math.max(v, maxV);
        }
        return maxW * maxV;
    }
}
