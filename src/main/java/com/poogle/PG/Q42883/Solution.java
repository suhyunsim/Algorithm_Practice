package main.java.com.poogle.PG.Q42883;

public class Solution {
    public static String solution(String number, int k) {
        StringBuilder ans = new StringBuilder();

        int idx = 0;
        int comp = 0;
        for (int i = 0; i < number.length() - k; i++) {
            comp = 0;
            for (int j = idx; j <= i + k; j++) {
                if (comp < number.charAt(j) - '0') {
                    comp = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            ans.append(comp);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
}
