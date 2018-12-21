package crackingcode.stack;

import java.util.Stack;

public class BalancedBracketRecursion {

    public static void main(String[] args) {
        String isBalanced = "[[]][][][[[]]]";
        Stack<String> s = new Stack<>();
        BalancedBracketRecursion brie = new BalancedBracketRecursion();
        brie.checkBalance(s, isBalanced);
        System.out.println("IS BALANCED? " + s.isEmpty());
    }

    public void checkBalance(Stack<String> stk, String s) {
        if (s.length() == 0) {
            return;
        }
        String check = s.substring(s.length() - 1, s.length());
        if (check.equals("]")) {
            stk.push(check);
        } else {
            if (!stk.isEmpty()) {
                stk.pop();
            }
        }
        checkBalance(stk, s.substring(0, s.length() - 1));
    }
}
