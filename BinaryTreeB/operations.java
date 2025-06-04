package BinaryTreeB;

import java.util.*;

public class operations {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1)
                return null;
            Node n = new Node(nodes[idx]);
            n.left = buildTree(nodes);
            n.right = buildTree(nodes);
            return n;
        }

        public static int sum(Node root) {
            if (root == null)
                return 0;
            int l = sum(root.left);
            int r = sum(root.right);
            return l + r + root.data;
        }

    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree t = new BinaryTree();
        Node root = t.buildTree(nodes);

        System.out.println("sum of all nodes " + t.sum(root));
    }
}
