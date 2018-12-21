package algorithm.datastructures;

import java.util.HashMap;
import java.util.LinkedList;

public class Trie {
    private TrieNode root = new TrieNode();

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("onomotopeia");
        trie.insert("octopus");
        trie.insert("thisisprobablythelongestwordever");
        TrieNode longest = trie.findLongest();
        System.out.println(longest.getActualWord());

    }

    public void insert(String insert) {
        HashMap<Character, TrieNode> parent = root.getChildren();
        TrieNode child = null;
        for (Character c : insert.toCharArray()) {
            child = parent.containsKey(c) ? parent.get(c) : new TrieNode();
            parent.put(c, child);
            parent = child.getChildren();

        }
        if (child != null) {
            child.setEndOfWord(true);
            child.setActualWord(insert);
        }
    }

    public TrieNode findLongest() {
        LinkedList<TrieNode> queue = new LinkedList();
        queue.push(root);
        TrieNode current = null;
        while (!queue.isEmpty()) {
            current = queue.pop();
            if (current.getChildren() != null) {
                for (TrieNode children : current.getChildren().values()) {
                    queue.push(children);
                }
            }
        }
        return current;
    }


    public class TrieNode {
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean endOfWord;
        private String actualWord;

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public void setEndOfWord(boolean end) {
            this.endOfWord = end;
        }

        public boolean getEndOfWord() {
            return endOfWord;
        }

        public String getActualWord() {
            return actualWord;
        }

        public void setActualWord(String actualWord) {
            this.actualWord = actualWord;
        }
    }
}

