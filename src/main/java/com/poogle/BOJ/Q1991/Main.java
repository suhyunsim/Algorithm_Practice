package main.java.com.poogle.BOJ.Q1991;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.create(root, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}

class Node {
    char data;
    Node left, right;

    public Node(char data) {
        this.data = data;
    }
}

class Tree {
    public Node root;

    public void create(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);
            root.left = leftData != '.' ? new Node(leftData) : null;
            root.right = rightData != '.' ? new Node(rightData) : null;
        } else {
            search(root, data, leftData, rightData);
        }
    }

    public void search(Node node, char data, char leftData, char rightData) {
        if (node == null) {
            return;
        } else if (node.data == data) {
            node.left = leftData != '.' ? new Node(leftData) : null;
            node.right = rightData != '.' ? new Node(rightData) : null;
        } else {
            search(node.left, data, leftData, rightData);
            search(node.right, data, leftData, rightData);
        }
    }

    // 전위순회: root -> l -> r
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.left != null)
                preOrder(node.left);
            if (node.right != null)
                preOrder(node.right);
        }
    }

    // 중위순회: l -> root -> r
    public void inOrder(Node node) {
        if (node != null) {
            if (node.left != null)
                inOrder(node.left);
            System.out.print(node.data);
            if (node.right != null)
                inOrder(node.right);
        }
    }

    // 후위순회: l -> r -> root
    public void postOrder(Node node) {
        if (node != null) {
            if (node.left != null)
                postOrder(node.left);
            if (node.right != null)
                postOrder(node.right);
            System.out.print(node.data);
        }
    }
}
