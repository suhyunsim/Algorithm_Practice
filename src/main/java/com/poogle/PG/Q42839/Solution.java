package main.java.com.poogle.PG.Q42839;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    private static int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) answer++;
            if (a % 2 != 0 && isPrime(a)) answer++;
        }
        return answer;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        else if (n == 2) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void permutation(String prefix, String numbers, HashSet<Integer> set) {
        int n = numbers.length();
        if (!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++) {
            permutation(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1, n), set);
        }

    }
}
