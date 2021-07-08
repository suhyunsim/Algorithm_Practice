package main.java.com.poogle.PG.Q43165;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        return bfs(numbers, target, numbers[0], 1) + bfs(numbers, target, -numbers[0], 1);
    }

    private static int bfs(int[] numbers, int target, int sum, int i) {
        if (numbers.length == i) {
            if (sum == target) return 1;
            else return 0;
        }
        int result = 0;
        result += bfs(numbers, target, sum + numbers[i], i + 1);
        result += bfs(numbers, target, sum - numbers[i], i + 1);
        return result;
    }
}
