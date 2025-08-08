package Tries;

public class creation {
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

    public static boolean search(String key) { // O(L)
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) { // any letter not found
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;// end of word becpmes true (found)
    }

    public static boolean startsWith(String prefix) { // O(L)
        Node curr = root;
        for (int level = 0; level < prefix.length(); level++) {
            int idx = prefix.charAt(level) - 'a';
            if (curr.children[idx] == null) { // any letter not found
                return false;
            }
            curr = curr.children[idx];
        }

        return true;// need not to be eow as true its just prefix
    }

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("the"));
        System.out.println(startsWith("an"));
        System.out.println(startsWith("thi"));
    }
}
