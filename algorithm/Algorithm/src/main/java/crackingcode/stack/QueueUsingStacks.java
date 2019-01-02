package crackingcode.stack;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<String> stack = new Stack();
    private Stack<String> stack2 = new Stack();


    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.push("first person");
        q.push("second person");
        q.push("third person");
        q.push("fourth person");

        System.out.println(q.pop());

    }

    public String pop() {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        String returnMe = stack2.pop();

        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        return returnMe;
    }


    public void push(String insert) {
        stack.push(insert);
    }


}
