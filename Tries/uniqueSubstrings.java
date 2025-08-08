package Tries;

public class uniqueSubstrings {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;// endOfWord

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }

        }
    }

    public static Node root = new Node();// an empty one

    public static void insert(String word) { // O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {// for all letters eow is false
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];// pointer from parent node to child node moves from letter to other
        }

        curr.eow = true;// end of word becpmes true
    }

    public static int countNodes(Node root) {
        if (root == null)
            return 0;

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {// if present count increases
                count += countNodes(root.children[i]);
            }
        }

        return count + 1;// for self

    }

    public static void main(String[] args) {
        String str = "ababa";

        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }
}