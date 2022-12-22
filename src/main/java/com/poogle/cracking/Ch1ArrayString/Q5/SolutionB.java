package main.java.com.poogle.cracking.Ch1ArrayString.Q5;

public class SolutionB {
    public static boolean oneEditAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }
        // a < b
        String s1 = a.length() < b.length() ? a : b;
        String s2 = a.length() < b.length() ? b : a;

        int index1 = 0;
        int index2 = 0;
        boolean diff = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                // different in first time
                if (diff)
                    return false;
                diff = true;
                // replace
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;

    }

    public static void main(String[] args) {
//        System.out.println(oneEditRemove("palee", "pale"));
//        System.out.println(oneEditRemove("pale", "pkle"));
        System.out.println(oneEditAway("acdsfdsfadsf", "acdsgdsfadsf"));
    }
}
