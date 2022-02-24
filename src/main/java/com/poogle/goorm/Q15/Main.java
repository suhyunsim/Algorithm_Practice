package main.java.com.poogle.goorm.Q15;

public class Main {

    public int solution(int n) {
        int[][] board = new int[n][n];
        int dir = 0; // 0, 1, 2, 3: 소용돌이 방향 순서
        int num = 1;
        int i = 0, j = 0;
        while (true) {
            board[i][j] = num;
            if (dir == 0 && (j == n - 1 || (j < n - 1 && board[i][j + 1] != 0))) dir++;
            else if (dir == 1 && (i == n - 1 || (i < n - 1 && board[i + 1][j] != 0))) dir++;
            else if (dir == 2 && (j == 0 || (j > 0 && board[i][j - 1] != 0))) dir++;
            else if (dir == 3 && (i == 0 || (i > 0 && board[i - 1][j] != 0))) dir = 0;
            if (dir == 0) j++;
            else if (dir == 1) i++;
            else if (dir == 2) j--;
            else if (dir == 3) i--;
            if (num == Math.pow(n, 2)) break;
            num++;
        }
        int answer = 0;
        i = 0;
        while (i < n) {
            answer += board[i][i];
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {

        Main sol = new Main();
        int n1 = 3;
        int ret1 = sol.solution(n1);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int ret2 = sol.solution(n2);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
