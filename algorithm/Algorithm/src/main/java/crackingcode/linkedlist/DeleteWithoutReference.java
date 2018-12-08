package crackingcode.linkedlist;

import algorithm.datastructures.LinkedListNode;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 * EXAMPLE
 * Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 */
public class DeleteWithoutReference {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode();
        head.setValue("head");

        LinkedListNode second = new LinkedListNode();
        second.setValue("second");
        head.setNext(second);

        LinkedListNode third = new LinkedListNode();
        third.setValue("third");
        second.setNext(third);

        deleteInPlace(second);
        System.out.println(head.getNext().getValue());
    }

    public static boolean deleteInPlace(LinkedListNode current){
        if(null == current || null == current.getNext()){
            return false;
        }
        LinkedListNode next = current.getNext();
        current.setValue(next.getValue());
        current.setNext(next.getNext());
        return true;

    }

}
