package main.java.com.poogle.PG.Q62048;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    private static long solution(int w, int h) {
        long sum = (long) w * (long) h;
        long not = 0;
        long gcd = calGCD(w, h);
        if (gcd == 1) {
            not = w + h - 1;
        } else if (gcd > 1) {
            not = gcd * ((w / gcd) + (h / gcd) - 1);
        }
        return sum - not;
    }

    private static long calGCD(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return calGCD(b, a % b);
    }

}
