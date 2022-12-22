package main.java.com.poogle.cracking.Ch1ArrayString.Q5;

public class Main {
    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        for (String[] test : tests) {
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");
            test(a, b, expected);
            test(b, a, expected);
        }
    }

    public static void test(String a, String b, boolean expected) {
        boolean resultA = SolutionA.oneEditRemove(a, b);
        boolean resultB = SolutionB.oneEditRemove(a, b);

        if (resultA == expected && resultB == expected) {
            System.out.println("success: " + a + ", " + b);
        } else {
            System.out.println("fail: " + a + ", " + b);
        }
    }
}

