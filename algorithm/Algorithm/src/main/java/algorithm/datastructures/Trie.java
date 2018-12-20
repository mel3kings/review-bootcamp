package algorithm.datastructures;

import java.util.HashMap;

public class Trie {
    private TrieNode root = new TrieNode();

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ABC");
        trie.insert("ADD");
        trie.insert("BDD");
        System.out.println(trie.contains("ABC"));
    }

    public void insert(String insert) { // ABC
        HashMap<Character, TrieNode> children = root.getChildren();
        TrieNode node = null;
        for (Character c : insert.toCharArray()) {
            node = children.containsKey(c) ? children.get(c) : new TrieNode();
            children.put(c, node);
            children = node.getChildren();
        }
        if (node != null) {
            node.setEndOfWord(true);
        }
    }

    public boolean contains(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();
        TrieNode node = null;
        for (Character c : word.toCharArray()) {
            node = children.get(c);
        }
        return node == null ? true : false;
    }

    class TrieNode {
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean endOfWord;

        public HashMap getChildren() {
            return children;
        }

        public void setEndOfWord(boolean end) {
            this.endOfWord = end;
        }

        public boolean getEndOfWord() {
            return endOfWord;
        }
    }
}

