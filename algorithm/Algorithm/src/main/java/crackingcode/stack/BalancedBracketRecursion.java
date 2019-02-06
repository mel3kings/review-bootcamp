package crackingcode.stack;

import java.util.Stack;

public class BalancedBracketRecursion {

    private static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        String isBalanced = "[[]][][][[[]]]";
        BalancedBracketRecursion brie = new BalancedBracketRecursion();
        brie.checkBalance(isBalanced);
        System.out.println("IS BALANCED? " + stack.isEmpty());
    }

    public void checkBalance(String s) {
        if (s.length() == 0) {
            return;
        }
        String check = s.substring(s.length() - 1, s.length());
        if (check.equals("]")) {
            stack.push(check);
        } else {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        checkBalance(s.substring(0, s.length() - 1));
    }
}
