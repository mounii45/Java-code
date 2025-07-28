package binarySearchTree;

import Arrays.pairSum;
import stackCreation.stackException;

public class AVL {
    public static Node root;

    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;

        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        return root.height;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int getBalanceFactor(Node root) {
        if (root == null)
            return 0;

        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node k1) {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.left), height(k2.right)) + 1;

        return k2;
    }

    public static Node rightRotate(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.left), height(k2.right)) + 1;

        return k1;

    }

    public static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        else if (root.data < data)
            root.right = insert(root.right, data);
        else if (root.data > data)
            root.left = insert(root.left, data);
        else
            return root;// duplicate vaues not allowed

        root.height = 1 + Math.max(height(root.left), height(root.right));// update height for every node

        int bf = getBalanceFactor(root);

        // Left Left case
        if (bf > 1 && root.left.data > data)
            return rightRotate(root);

        // Right Right case
        if (bf < -1 && root.right.data < data)
            return leftRotate(root);

        // Left Right case
        if (bf > 1 && root.left.data < data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left case
        if (bf < -1 && root.right.data > data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 10);
        root = insert(root, 25);
        root = insert(root, 30);
        root = insert(root, 22);
        root = insert(root, 50);

        preorder(root);

    }
}
