package main.java.com.poogle.PG.Q92335;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {
        String newNum = toKNum(n, k);
        int j, answer = 0;
        for (int i = 0; i < newNum.length(); i = j) {
            for (j = i + 1; j < newNum.length() && newNum.charAt(j) != '0'; j++);
            if (isPrime(Long.parseLong(newNum.substring(i, j)))) answer++;
        }
        return answer;
    }

    private static String toKNum(int n, int k) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.insert(0, n % k);
            n /= k;
        }
        return String.valueOf(res);
    }

    private static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
