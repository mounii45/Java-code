package BinaryTreeB;

public class sumTree {
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

        public static void inorder(Node root) {
            if (root == null)
                return;

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static int transform(Node root) {
        if (root == null)
            return 0;

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        int oldVal = root.data; // for not loosing the data to return
        root.data = leftSum + rightSum;// changing original value

        return root.data + oldVal; // return sum of subtree

    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree t = new BinaryTree();
        Node root = t.buildTree(nodes);

        transform(root);

        t.inorder(root);

    }
}
