package main.java.com.poogle.PG.Q12905;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
    }

    private static int solution(int[][] board) {
        int[][] newBoard = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, newBoard[i + 1], 1, board[i].length);
        }
        int max = 0;

        for (int i = 1; i < newBoard.length; i++) {
            for (int j = 1; j < newBoard[i].length; j++) {
                /* 2x2 사각형의 우측하단 꼭짓점을 기준으로 정사각형이 되는지 체크한다.
                 * 현재 값이 1인경우 좌←, 상↑, 좌상↖ 체크
                 * ←, ↑, ↖ 값이 모두 1인경우 정사각형을 만들 수 있음
                 */
                //newBoard에 들어가는 값(정사각형 한 변의 길이)
                if (newBoard[i][j] == 1) {
                    newBoard[i][j] = Math.min(Math.min(newBoard[i - 1][j], newBoard[i][j - 1]), newBoard[i - 1][j - 1]) + 1;
                    max = Math.max(max, newBoard[i][j]);
                }
            }
        }
        return max * max;
    }

}
