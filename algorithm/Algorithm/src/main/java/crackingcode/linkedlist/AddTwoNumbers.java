package crackingcode.linkedlist;

import java.util.LinkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        list.add(3);
        list.add(1);
        list.add(1);
        list.add(1);

        LinkedList<Integer> list2 = new LinkedList();
        list2.add(5);
        list2.add(9);
        list2.add(2);
        list2.add(0);

        addLists(list, list2).forEach(System.out::print);
    }

    public static LinkedList<Integer> addLists(LinkedList<Integer> one, LinkedList<Integer> two) {
        LinkedList<Integer> result = new LinkedList<>();
        int carryOver = 0;
        int firstValue = 0, secondValue = 0;

        while (one.peekLast() != null || two.peekLast() != null) {
            if (one.peek() != null)
                firstValue = one.pollLast();
            if (two.peek() != null)
                secondValue = two.pollLast();

            int sum = firstValue + secondValue + carryOver;

            if (sum >= 10) {
                carryOver = 1;
                sum = sum % 10;
                result.push(sum);
            } else {
                carryOver = 0;
                result.push(sum);
            }
            firstValue = 0;
            secondValue = 0;
        }
        return result;
    }


}
