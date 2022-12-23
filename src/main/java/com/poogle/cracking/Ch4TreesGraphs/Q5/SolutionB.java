package main.java.com.poogle.cracking.Ch4TreesGraphs.Q5;

public class SolutionB {
    public static void main(String[] args) {
//                int[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1}; // false
//                int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1}; // false
//                int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE}; // false
//                int[] array = {1, 2, 3, 4}; // true
//                int[] array = {2, 2, 3, 4}; // true
//                int[] array = {2, 1, 3, 4}; // false
//                int[] array = {5, 5, 6, 7}; // true
        int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE}; // true

        TreeNode node = TreeNode.createMinimalBST(array);
        System.out.println(checkBST(node));
        node.print();
    }


    private static boolean checkBST(TreeNode node) {
        return checkBST(node, null, null);
    }

    public static boolean checkBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((min != null && node.data <= min) || (max != null && node.data > max)) {
            return false;
        }

        if (!checkBST(node.left, min, node.data) || !checkBST(node.right, node.data, max)) {
            return false;
        }
        return true;
    }


}
