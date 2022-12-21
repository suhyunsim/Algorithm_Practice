package main.java.com.poogle.cracking.Ch1ArrayString.Q2;

import java.util.Arrays;

public class SolutionA {
    /*
    Given two strings, write a method to decide if one is a permutation of the other.
     */
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            System.out.println(isPermutation(pair[0], pair[1]));
        }
    }

    public static boolean isPermutation(String word1, String word2) {
        // 1. If length is different -> false
        if (word1.length() != word2.length()) {return false;}
        // 2. Make character array
        char[] arrA = word1.toCharArray();
        char[] arrB = word2.toCharArray();
        // 3. Sort each array
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        // 4. Check difference
        return new String(arrA).equals(new String(arrB));
    }
}
