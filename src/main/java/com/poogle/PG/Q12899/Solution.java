package main.java.com.poogle.PG.Q12899;


public class Solution {
    public static String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();
        while (n > 0) {
            int remainder = n % 3;
            n /= 3;
            if (remainder % 3 == 0) n--;

            answer.insert(0, numbers[remainder]);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(10));
    }
}
