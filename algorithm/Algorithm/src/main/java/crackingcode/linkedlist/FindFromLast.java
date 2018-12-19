package crackingcode.linkedlist;

import algorithm.datastructures.LinkedListNode;
import util.Utils;

import java.util.LinkedHashMap;

public class FindFromLast {

    /***
     * Implement an algorithm to find the nth to last element of a singly linked list.
     * @param args
     */
    public static void main(String[] args) {
        LinkedListNode node = Utils.generateSinglyListNode();
        FindFromLast f = new FindFromLast();
        f.save(node, 0);
        LinkedListNode found = map.get(map.size() - 2);
        System.out.println(found.getValue());
    }

    public static LinkedHashMap<Integer, LinkedListNode> map = new LinkedHashMap<>();

    public void save(LinkedListNode node, int pos) {
        map.put(pos, node);
        if (node.getNext() != null) {
            save(node.getNext(), pos + 1);
        }
    }
}
