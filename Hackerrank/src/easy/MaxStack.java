package easy;

import java.util.*;

public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        pushHelper(x);
    }

    public void pushHelper(int x) {
        int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (x > tempMax) {
            tempMax = x;
        }
        stack.push(x);
        maxStack.push(tempMax);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();

        while (stack.peek() != max) {
            temp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while (!temp.isEmpty()) {
            int x = temp.pop();
            pushHelper(x);
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

//["MaxStack","push","push", "pop", "push","push", "peekMax", "push","push", "top","peekMax"]
//[[],[5],[1],[],[1],[10],[],[1000],[200], [], []]
//["MaxStack","push","push","push", "popMax","peekMax", "popMax"]
//[[],[5],[1],[100],[],[],[]]
//["MaxStack", "push", "push", "push", "top", "popMax"]
//[[], [5], [1], [5], [], []]
//["MaxStack", "push", "push", "push", "push","push","push","top", "popMax"]
//[[], [5], [1], [5], [100], [2],[500],[],[]]
//["MaxStack", "push", "push", "push", "push","push","push","top", "popMax","top","popMax","pop","top"]
//[[], [5], [1], [5], [100], [2],[500],[],[],[],[],[],[]]
//["MaxStack", "push", "push", "push", "push","push","push","push", "push", "push", "push","push","push","top", "popMax","top","popMax","pop","top"]
//[[], [5], [1], [5], [100], [2],[500],[5], [1], [5], [100], [2],[500],[],[],[],[],[],[]]
//["MaxStack","push","popMax","push","push","push","pop","peekMax","push","pop","pop","push","peekMax","peekMax","push","peekMax","push","peekMax"]
//[[],[-2],[],[-45],[-82],[29],[],[],[40],[],[],[66],[],[],[-61],[],[98],[]]
//["MaxStack","push","popMax","push","push","push","pop","peekMax","push","pop","pop","push","peekMax","peekMax","push","peekMax","push","peekMax"]
//[[],[-2],[],[-45],[-82],[29],[],[],[40],[],[],[66],[],[],[-61],[],[98],[]]
//["MaxStack","push","popMax","push","push","push","pop","peekMax","push","pop","pop","push","peekMax","peekMax","push","peekMax","push","peekMax"]
//[[],[-2],[],[-45],[-82],[29],[],[],[40],[],[],[66],[],[],[-61],[],[98],[]]
//["MaxStack","push","popMax","push","push","push","pop","peekMax","push","pop","pop","push","peekMax","peekMax","push","peekMax","push","peekMax"]
//[[],[-2],[],[-45],[-82],[29],[],[],[40],[],[],[66],[],[],[-61],[],[98],[]]
//["MaxStack","push","top","push","top","push","pop","pop","push","top","push","popMax","top","push","push","top","popMax","popMax"]
//[[],[92],[],[54],[],[22],[],[],[-57],[],[-24],[],[],[26],[-71],[],[],[]]
//["MaxStack","push", "push", "peekMax", "popMax","popMax"]
//[[],[-57],[-24],[],[],[]]