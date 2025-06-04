package BinaryTreeB;

public class minDistance {
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

    public static Node lowestCommonAncestor(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        Node leftLca = lowestCommonAncestor(root.left, p, q); // check in left
        Node rightLca = lowestCommonAncestor(root.right, p, q);// in right

        if (leftLca == null)// if right not present
            return rightLca;
        if (rightLca == null)
            return leftLca;
        return root;// if left & right lca not null
    }

    public static int getMinDistance(Node root, int n) {

        if (root == null)
            return -1;
        if (root.data == n)
            return 0;

        int leftDist = getMinDistance(root.left, n);
        int rightDist = getMinDistance(root.right, n);

        if (leftDist == -1 && rightDist == -1)
            return -1;
        else if (leftDist == -1)
            return rightDist + 1;
        else
            return leftDist + 1;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree t = new BinaryTree();
        Node root = t.buildTree(nodes);

        int n1 = 4, n2 = 6;
        Node lca = lowestCommonAncestor(root, n1, n2);

        int dist1 = getMinDistance(lca, n1);
        int dist2 = getMinDistance(lca, n2);
        System.out.println("minimum dist is " + (dist1 + dist2));

    }
}
