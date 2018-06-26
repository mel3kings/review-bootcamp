package algorithm.datastructures;

import java.util.HashMap;

public class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    private boolean endOfWord = false;

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
