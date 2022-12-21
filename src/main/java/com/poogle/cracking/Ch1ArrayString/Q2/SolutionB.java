package main.java.com.poogle.cracking.Ch1ArrayString.Q2;

public class SolutionB {
    /*
    Given two strings, write a method to decide if one is a permutation of the other.
     */
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            System.out.println(isPermutation(pair[0], pair[1]));
        }
    }

    public static boolean isPermutation(String wordA, String wordB) {
        // 1. Assume ASCII
        int[] charArr = new int[128];
        // 2. If len is diff -> false
        if (wordA.length() != wordB.length())
            return false;
        // 3. check all chars in wordA and cnt++;
        for (char c : wordA.toCharArray()) {
            charArr[c]++;
        }
        // 4. check all chars in wordB and cnt--;
        for (char c : wordB.toCharArray()) {
            charArr[c]--;
            // 5-1. If wordA and wordB has different count of chars -> false
            if (charArr[c] < 0)
                return false;
        }
        // 5-2. else true
        return true;
    }

}
