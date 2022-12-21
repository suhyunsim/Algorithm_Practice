package main.java.com.poogle.cracking.Ch1ArrayString.Q1;

    /*
    Q. Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?
     */

public class SolutionB {
    public static void main(String[] args) {
        String[] words = new String[]{"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(isUnique(word));
        }
    }

    // Assumes only letters a ~ z
    public static boolean isUnique(String word) {
        if (word.length() > 26)
            return false;
        int checker = 0;
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0)
                return false;
            checker |= (1 << val);
        }
        return true;
    }
}
