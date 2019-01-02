package crackingcode.linkedlist;

import algorithm.datastructures.LinkedListNode;
import util.Utils;

import java.util.HashMap;

public class CheckIfCircular {

    public static void main(String[] args) {
        LinkedListNode circular = Utils.generateSinglyListNode();
        LinkedListNode found = isCircular(circular);
        System.out.println("Circular Point: " + found.getValue());
    }

    private static HashMap<String, LinkedListNode> map = new HashMap();

    public static LinkedListNode isCircular(LinkedListNode node) {
        if (null != node.getNext() && !map.containsKey(node.getValue())) {
            map.put(node.getValue(), node);
            return isCircular(node.getNext());
        } else if (map.containsKey(node.getValue())) {
            return node;
        } else {
            return null;
        }

    }
}
