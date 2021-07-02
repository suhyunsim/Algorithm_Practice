package main.java.com.poogle.PG.Q12951;

public class Solution {
    public static String solution(String s) {
        StringBuilder ans = new StringBuilder();
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;
        for (String ss : sp) {
            ans.append(flag ? ss.toUpperCase() : ss);
            flag = ss.equals(" ") ? true : false;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("people  unFollowed me "));
        System.out.println(solution("aaaaa aaa "));
    }
}
