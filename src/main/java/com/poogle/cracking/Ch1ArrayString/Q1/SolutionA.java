package main.java.com.poogle.cracking.Ch1ArrayString.Q1;

public class SolutionA {
    /*
    Q. Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?
     */
    public static void main(String[] args) {
        String[] words = new String[]{"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(isUnique(word));
        }
    }

    private static boolean isUnique(String word) {
        // 1. Make a boolean arr for ascii
        boolean[] arrAlpha = new boolean[256];
        for (int i = 0; i < word.length(); i++) {
            // 2. make true if it appears
            // 3-1. If any char appear again -> return false
            if (arrAlpha[word.charAt(i)]) return false;
            // 3-2. If all chars are true until the len of word -> true
            arrAlpha[word.charAt(i)] = true;
        }
        return true;
    }
}
