package main.java.com.poogle.PG.Q12934;

public class Solution {
    static long solution(long n) {
        if (Math.pow((int) Math.sqrt(n), 2) == n) return (long) Math.pow(Math.sqrt(n) + 1, 2);
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(121));
    }
}
