
package main.java.com.poogle.PG.Q43165;

public class Solution {

    static int answer, target;
    static int[] numbers;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }

    public static int solution(int[] numbers, int target) {
        answer = 0;
        Solution.target = target;
        Solution.numbers = numbers;

        dfs(0, 0);

        return answer;
    }

    private static void dfs(int sum, int i) {
        //1. 탈출 조건
        if (numbers.length == i) {
            if (target == sum) answer++;
            return;
        }

        //2. 실행 동작
        dfs(sum + numbers[i], i + 1);
        dfs(sum - numbers[i], i + 1);
    }
}