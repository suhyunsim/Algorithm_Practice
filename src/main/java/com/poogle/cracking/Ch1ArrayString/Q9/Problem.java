package main.java.com.poogle.cracking.Ch1ArrayString.Q9;

public class Problem {
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair: pairs) {
            System.out.println(isRotation(pair));
        }
    }

    private static boolean isRotation(String[] pair) {
        String str1 = pair[0];
        String str2 = pair[1];
        int len = str1.length();
        if (len == str2.length() && len > 0) {
            String s1s1 = str1 + str1;
            return isSubString(s1s1, str2);
        }
        return false;
    }

    private static boolean isSubString(String big, String small) {
        return big.contains(small);
    }
}
