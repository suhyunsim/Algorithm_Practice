package main.java.com.poogle.cracking.Ch4TreesGraphs.Q5;

public class SolutionA {
    static Integer lastPrinted = null;

    public static void main(String[] args) {
//        int[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1}; // false
//        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1}; // false
        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE}; // true
//        int[] array = {1, 2, 3, 4}; // true
//        int[] array = {2, 2, 3, 4}; // true
//        int[] array = {2, 1, 3, 4}; // false
//        int[] array = {5, 5, 6, 7}; // true
//        int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};

        TreeNode node = TreeNode.createMinimalBST(array);
        System.out.println(checkBST(node));
        node.print();
    }


    private static boolean checkBST(TreeNode node) {
        return checkBST(node, true);
    }

    public static boolean checkBST(TreeNode node, boolean isLeft) {
        if (node == null) {
            return true;
        }

        if (!checkBST(node.left, true)) {
            return false;
        }

        if (lastPrinted != null) {
            if (isLeft) {
                if (node.data < lastPrinted) {
                    return false;
                }
            } else {
                if (node.data <= lastPrinted) {
                    return false;
                }
            }
        }
        lastPrinted = node.data;

        if (!checkBST(node.right, false)) {
            return false;
        }
        return true;
    }

}
