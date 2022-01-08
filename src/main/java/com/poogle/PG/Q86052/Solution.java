package main.java.com.poogle.PG.Q86052;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static int row, column;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1}; //아, 왼, 위, 오
    static boolean[][][] isVisited;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"SL", "LR"})));
    }

    private static int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        row = grid.length;
        column = grid[0].length();

        isVisited = new boolean[row][column][4];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!isVisited[i][j][d]) {
                        answer.add(light(grid, i, j, d));
                    }
                }
            }
        }
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    private static int light(String[] grid, int r, int c, int d) {
        int cnt = 0;
        while (true) {
            if (isVisited[r][c][d])
                break;

            cnt++;
            isVisited[r][c][d] = true; //방문

            if (grid[r].charAt(c) == 'L')
                d = d == 0 ? 3 : d - 1;
            /*
            0 -> 3
            1 -> 0
            2 -> 1
            3 -> 2
            */
            else if (grid[r].charAt(c) == 'R')
            /*
            2 -> 3
            0 -> 1
            3 -> 0
            1 -> 2
            */
            d = d == 3 ? 0 : d + 1;

            r = (r + dr[d] + row) % row;
            c = (c + dc[d] + column) % column;
        }
        return cnt;
    }

}
