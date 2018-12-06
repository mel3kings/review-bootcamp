package crackingcode.linkedlist;

import algorithm.datastructures.LinkedListNode;

import java.util.HashMap;


public class FindDuplicates {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode();
        head.setValue("head");

        LinkedListNode second = new LinkedListNode();
        second.setValue("second");
        head.setNext(second);

        LinkedListNode third = new LinkedListNode();
        third.setValue("third");
        second.setNext(third);

        LinkedListNode duplicate = new LinkedListNode();
        duplicate.setValue("second");
        third.setNext(duplicate);

        LinkedListNode forth = new LinkedListNode();
        forth.setValue("forth");
        duplicate.setNext(forth);

        removeDuplicates(head);
        printAll(head);
    }

    /**
     * Notes: be careful on creating variables inside method it might referring to same node
     * Be wary on while loops make sure it is being updated
     * @param current
     */
    public static void removeDuplicates(LinkedListNode current) {
        HashMap<String, Boolean> map = new HashMap<>();
        LinkedListNode previous = null;

        while (current != null) {
            if (map.containsKey(current.getValue())) {
                previous.setNext(current.getNext());
            } else {
                map.put(current.getValue(), true);
                previous = current;
            }
            current = current.getNext();
        }
    }


    public static void printAll(LinkedListNode n) {
        if (n != null) {
            System.out.println(n.getValue() + " ->");
            printAll(n.getNext());
        }
    }
}
