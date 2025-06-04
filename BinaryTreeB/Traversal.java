package BinaryTreeB;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

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

        public static void preorder(Node root) {
            if (root == null)
                return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null)
                return;

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null)
                return;

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);// for root 1st level

            while (!q.isEmpty()) {
                Node curr = q.remove();// 1st ele
                if (curr != null) {
                    System.out.print(curr.data + " ");
                    if (curr.left != null)
                        q.add(curr.left);
                    if (curr.right != null)
                        q.add(curr.right);
                } else {
                    System.out.println();
                    if (q.isEmpty())// for end of tree level
                        break;
                    else
                        q.add(null);// intimating the end of level by pushing null
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree t = new BinaryTree();
        Node root = t.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("preorder :");
        t.preorder(root);
        System.out.println();
        System.out.println("inorder :");

        t.inorder(root);
        System.out.println();
        System.out.println("postorder");
        t.postorder(root);

        System.out.println();
        System.out.println("levelorder");
        t.levelorder(root);
    }
}
