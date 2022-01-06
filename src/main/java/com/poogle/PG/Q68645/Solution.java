package main.java.com.poogle.PG.Q68645;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
    }

    private static int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] arr = new int[n][n];
        int x = -1, y = 0, num = 1, k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    answer[k++] = arr[i][j];
                }
            }
        }
        return answer;
    }

}
