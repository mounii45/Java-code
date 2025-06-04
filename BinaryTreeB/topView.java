package BinaryTreeB;

import java.util.*;

public class topView {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static TreeNode buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1)
                return null;
            TreeNode n = new TreeNode(nodes[idx]);
            n.left = buildTree(nodes);
            n.right = buildTree(nodes);
            return n;
        }

    }

    static class Info {
        int hd;
        TreeNode node;

        public Info(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void verticalTraversal(TreeNode root) {
        if (root == null)
            return;
        // Level Order
        Queue<Info> q = new LinkedList<>();
        Map<Integer, TreeNode> map = new TreeMap<>();// sorted

        int min = 0, max = 0;

        q.add(new Info(root, 0));// assigning root hd as 0 like origin
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty())
                    break;
                else
                    q.add(null);// indicating the end of level
            } else {
                if (!map.containsKey(curr.hd)) {// hd value occuring for 1st time pushes in hasmap
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {// finding min & max fortraversal
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {// finding min & max fortraversal & assigning hd values
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(min, curr.hd + 1);
                }

            }

        }
        for (int i = min; i <= max; i++) {
            System.out.println(map.get(i).data);
        }
    }

    public static void kLevel(TreeNode root, int i, int k) {
        if (root == null)
            return;
        if (i == k) {
            System.out.print(root.data + " ");
            return;
        }
        kLevel(root.left, i + 1, k);
        kLevel(root.right, i + 1, k);
    }

    public static void main(String args[]) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree t = new BinaryTree();
        TreeNode root = t.buildTree(nodes);
        verticalTraversal(root);
        kLevel(root, 1, 3);
    }
}
