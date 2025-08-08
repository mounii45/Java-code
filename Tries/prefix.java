package Tries;

public class prefix {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;// endOfWord
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;

        }
    }

    public static Node root = new Node();// an empty one

    public static void insert(String word) { // O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {// for all letters eow is false
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];// pointer from parent node to child node moves from letter to other
        }

        curr.eow = true;// end of word becpmes true
    }

    public static void findPrefix(Node root, String ans) { // O(L) : l=longest word in trie

        if (root == null) {// base case
            return;
        }

        if (root.freq == 1)// base case stop when freq is 1
        {
            System.out.println(ans);
            return;
        }
        for (int level = 0; level < root.children.length; level++) {

            if (root.children[level] != null) { // any letter not found
                findPrefix(root.children[level], ans + (char) (level + 'a'));//
            }

        }

    }

    public static void main(String[] args) {
        String words[] = { "zebra", "dog", "duck", "dove" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        root.freq = -1;

        findPrefix(root, "");

    }

}
