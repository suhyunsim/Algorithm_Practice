package main.java.com.poogle.PG.Q12901;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b) {
        String[] year = new String[366];
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        for (int i = 0; i < year.length; i++) {
            year[i] = days[(i + 5) % 7];
        }
        int ans = 0;
        for (int i = 0; i < a - 1; i++) {
            ans += month[i];
        }
        //1월 1일 count 막기 위해
        ans += b - 1;
        return year[ans];
    }
}
