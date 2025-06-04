package BinaryTreeB;

public class kthAncestor {
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

    }

    public static int kancestor(Node root, int n, int k) {
        if (root == null)
            return -1;
        if (root.data == n)
            return 0;
        int leftFind = kancestor(root.left, n, k);
        int rightFind = kancestor(root.right, n, k);

        if (leftFind == -1 && rightFind == -1)
            return -1;
        else if (leftFind == -1) {
            int res = rightFind + 1;
            if (res == k)
                return root.data;
            return res;
        } else {
            int res = leftFind + 1;
            if (res == k)
                return root.data;
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        /*
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 6
         */
        BinaryTree t = new BinaryTree();
        Node root = t.buildTree(nodes);

        int n = 5, k = 1;

        int res = kancestor(root, n, k);

        System.out.println("kth ancestor :" + res);

    }
}

/*
 * public static Node lowestCommonAncestor(Node root, int p, int q) {
 * if (root == null || root.data == p || root.data == q) {
 * return root;
 * }
 * 
 * Node leftLca = lowestCommonAncestor(root.left, p, q); // check in left
 * Node rightLca = lowestCommonAncestor(root.right, p, q);// in right
 * 
 * if (leftLca == null)// if right not present
 * return rightLca;
 * if (rightLca == null)
 * return leftLca;
 * return root;// if left & right lca not null
 * }
 * 
 */