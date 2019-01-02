package crackingcode.stack;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(6);
        stack.push(8);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(7);
        stack = sort(stack);
        stack.forEach(System.out::println);
    }

    public static Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> buffer = new Stack<>();
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!buffer.isEmpty() && buffer.peek() > temp){
                stack.push(buffer.pop());
            }
            buffer.push(temp);
        }
        return buffer;
    }
}
