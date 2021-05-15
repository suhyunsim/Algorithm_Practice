package main.java.com.poogle.PG.Q67256;

public class Solution {
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        int lDis = 0;
        int rDis = 0;
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                sb.append("L");
                left = n;
            } else if (n == 3 || n == 6 || n == 9) {
                sb.append("R");
                right = n;
            } else {
                if (n == 0) n += 11;
                lDis = Math.abs(n - left) / 3 + Math.abs(n - left) % 3;
                rDis = Math.abs(right - n) / 3 + Math.abs(right - n) % 3;
                if (lDis == rDis) { //거리가 같을 때
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = n;
                    } else {
                        sb.append("R");
                        right = n;
                    }
                } else if (lDis > rDis) {
                    sb.append("R");
                    right = n;
                } else {
                    sb.append("L");
                    left = n;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String ans = solution(numbers, hand);
        System.out.println(ans);
    }
}
