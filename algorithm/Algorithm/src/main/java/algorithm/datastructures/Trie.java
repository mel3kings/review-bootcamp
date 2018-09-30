package algorithm.datastructures;

import java.util.HashMap;

public class Trie {
    private TrieNode root = new TrieNode();

    public void insert(String word){
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode t = null;
        for(Character c : word.toCharArray()){
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode();
                children.put(c,t);
            }
            children = t.getChildren();
        }
        if(null != t){
            t.setEndOfWord(true);
        }
    }


    public static void main(String[] args){
        String test = "programming";
        Trie structure = new Trie();
        structure.insert(test);
        System.out.println(structure);
    }
}
