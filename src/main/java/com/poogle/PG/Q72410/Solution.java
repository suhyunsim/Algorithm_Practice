package main.java.com.poogle.PG.Q72410;

public class Solution {
    public static String solution(String new_id) {
        StringBuilder answer = new StringBuilder(new_id.toLowerCase());
        answer = new StringBuilder(answer.toString().replaceAll("[^-_.a-z0-9]", ""));

        while (answer.toString().contains("..")) {
            answer = new StringBuilder(answer.toString().replace("..", "."));
        }
        if (answer.charAt(0) == '.') {
            answer = new StringBuilder(answer.toString().replaceFirst(".", ""));
        }
        if (answer.length() > 1) {
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
            }
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
            }
        }
        if (answer.toString().contains(" ")) {
            answer = new StringBuilder(answer.toString().replaceAll(" ", "a"));
        }
        if (answer.length() == 0) {
            answer.append("a");
        }
        if (answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));
        }
        if (answer.charAt(answer.length() - 1) == '.') {
            answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        }
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                if (answer.length() == 2) {
                    answer.append(answer.charAt(answer.length() - 1));
                } else {
                    answer.append(answer.charAt(0));
                }
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println("bat.y.abcdefghi");
        System.out.println(solution("z-+.^."));
        System.out.println("z--");
        System.out.println(solution("=.="));
        System.out.println("aaa");
        System.out.println(solution("123_.def"));
        System.out.println("123_.def");
        System.out.println(solution("abcdefghijklmn.p"));
        System.out.println("abcdefghijklmn.p");
    }
}
