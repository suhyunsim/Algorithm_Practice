package main.java.com.poogle.cracking.Ch1ArrayString.Q6;

public class Solution {
    public static void main(String[] args) {
        System.out.println(compress("aaabbccc"));
    }

    private static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            cnt++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(cnt);
                cnt = 0;
            }
        }
        return sb.length() < str.length() ? String.valueOf(sb) : str;
    }
}
