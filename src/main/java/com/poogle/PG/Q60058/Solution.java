package main.java.com.poogle.PG.Q60058;

import java.util.Stack;

public class Solution {
    public static String solution(String p) {
        return dfs(p);
    }

    private static String dfs(String w) {
        //1. 빈 문자열
        if (w.length() == 0) {
            return "";
        }
        String u = "";
        String v = "";
        int lCnt = 0;
        int rCnt = 0;

        //2. 균형잡힌 문자열 분리
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') lCnt++;
            else rCnt++;
            u += w.charAt(i);
            if (lCnt == rCnt) {
                v += w.substring(i + 1);
                break;
            }
        }

        //3. u 올바른 괄호 문자열이면 -> v 1단계 (3-1. 결과를 u에 붙여서)
        if (isCorrect(u)) {
            return u += dfs(v);
        //4. 아니면
        } else {
            //4-1. 첫번째 '('
            String tmp = "(";
            //4-2. v 재귀적으로 수행
            tmp += dfs(v);
            //4-3. ')' 붙이기
            tmp += ")";
            //4-4. 앞뒤 제거
            u = u.substring(1, u.length() - 1);
            //4-4. 나머지 문자열의 괄호 방향 뒤집어서 뒤에 붙이기
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') tmp += ")";
                else tmp += "(";
            }
            //4-5. 반환
            return tmp;
        }
    }

    private static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        String[] str = s.split("");
        for (String st : str) {
            if (st.equals("(")) {
                stack.push('(');
            } else {
                if (stack.isEmpty() || stack.peek() == ')') return false;
                else stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println("--");
        System.out.println(solution(")("));
        System.out.println("--");
        System.out.println(solution("()))((()"));
    }
}
