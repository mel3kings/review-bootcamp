package easy;

import java.util.Arrays;

public class MaxStack {
    private Integer[] stack;
    private int p = 0;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new Integer[5];
    }

    public void push(int x) {
        if (p+1 >= stack.length) {
            int newSize = stack.length * 2;
            Integer[] newStack = Arrays.copyOfRange(stack, 0, newSize);
            stack = newStack;
        }
        stack[p] = x;
        p++;
    }

    public int pop() {
        int index= findNextAvailable();
        int temp = stack[index];
        stack[index] = null;
        return temp;
    }

    public int top() {
        int index= findNextAvailable();
        return stack[index];
    }

    public int peekMax() {
        int index = findMax();
        return stack[index];
    }

    public int popMax() {
        int index = findMax();
        int max = stack[index];
        stack[index] = null;
        return max;
    }

    private int findMax() {
        Integer max = null;
        int maxIndex = 0;
        for (int i = 0; i < stack.length; i++) {
            Integer curr = stack[stack.length - i - 1];
            if (curr == null) continue;
            if (max == null || curr > max) {
                max = curr;
                maxIndex = stack.length - i - 1;
            }
        }
        return maxIndex;
    }

    private int findNextAvailable(){
        Integer remove = null;
        while (remove == null) {
            remove = stack[p];
            if (remove != null) {
                return p;
            }
            p--;
        }
        return p;
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