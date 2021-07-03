package main.java.com.poogle.PG.Q12945;

public class Solution {
    static int solution(int n) {
        int ans = 0;
        int a1 = 1;
        int a2 = 1;
        if (n == 1 || n == 2) return 1;
        else {
            for (int i = 3; i <= n; i++) {
                ans = (a1 + a2) % 1234567;
                a1 = a2;
                a2 = ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }
}
