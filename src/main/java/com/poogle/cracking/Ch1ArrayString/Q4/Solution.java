package main.java.com.poogle.cracking.Ch1ArrayString.Q4;

public class Solution {
    public static void main(String[] args) {
        String str = "taco cat";
        String str2 = "taco catt";
        String str3 = "taco cattt";
        String str4 = "ΩΩΩΩtaco cattt";
        String str5 = "Rats star evil live";
        String str6 = "Rats star evil livea";
        String[] strArrs = {str, str2, str3, str4, str5, str6};
        for (String s : strArrs) {
            System.out.println(solutionA(s));
        }
    }

        /*
        - If there are other types of characters (w/o alphabet) -> return false
        - X Care about the whitespace
        - Treat all the alphabets same whether upper/lower chars
        */

    public static boolean solutionA(String line) {
        int[] alphaArr = new int[26];
        String woSpace = line.replaceAll(" ", "");
        for (char c : woSpace.toCharArray()) {
            if ((c - 'a') > 26)
                return false;
        }
        String newString = woSpace.toLowerCase();
        char[] arr = newString.toCharArray();
        for (char c : arr) {
            alphaArr[c - 'a']++;
        }
        // If length is even -> all alpha cnt even
        if (arr.length % 2 == 0) {
            for (int i : alphaArr) {
                if (i % 2 != 0)
                    return false;
            }
            return true;
            // If length is odd -> only one alpha cnt odd
        } else {
            int cntOdd = 0;
            for (int i : alphaArr) {
                if (i % 2 != 0)
                    cntOdd++;
            }
            return cntOdd >= 1;
        }
    }
}