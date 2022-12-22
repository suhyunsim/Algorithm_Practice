package main.java.com.poogle.cracking.Ch1ArrayString.Q5;

public class SolutionA {
    public static boolean oneEditRemove(String a, String b) {
        if (a.length() == b.length()) {
            return oneEditReplace(a, b);
        // b > a
        } else if (a.length() + 1 == b.length()) {
            return oneEditInsert(a, b);
        // a > b
        } else if (a.length() == b.length() + 1) {
            return oneEditInsert(b, a);
        }
        return false;
    }

    private static boolean oneEditInsert(String a, String b) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < b.length() && index1 < a.length()) {
            if (a.charAt(index1) != b.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index1++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String a, String b) {
        boolean diff = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (diff) {
                    return false;
                }
                diff = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(oneEditRemove("pse", "pale"));
        System.out.println(oneEditRemove("acdsfdsfadsf", "acdsgdsfadsf"));

    }
}
