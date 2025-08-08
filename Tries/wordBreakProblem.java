package Tries;

import java.util.Arrays;
import java.util.List;

public class wordBreakProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;// endOfWord

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }

        }
    }

    public static Node root = new Node();

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

    public static boolean search(String key) {// O(L)
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

    public static boolean wordBreakHelper(String s) {
        if (s.length() == 0)
            return true;
        for (int i = 1; i <= s.length(); i++) {// from index 1
            if (search(s.substring(0, i)) && wordBreakHelper(s.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        for (int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }

        System.out.println(wordBreakHelper(s));

    }
}
