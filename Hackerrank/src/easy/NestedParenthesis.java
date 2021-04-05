package easy;

import java.util.*;

//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

public class NestedParenthesis {
    int counter = 0;

    public int maxDepth(String s) {
        Stack<Character> stk = new Stack();
        char[] val = s.toCharArray();
        int temp = 0;
        for (char c : val) {
            if (c != '(' && c != ')') continue;
            if (c == '(') {
                stk.push(c);
                temp++;
                counter = Math.max(counter, temp);
                continue;
            }

            if (c == ')') {
                temp--;
                stk.pop();
                counter = Math.max(counter, temp);
                continue;
            }

        }
        return counter;
    }
}
