package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Checks if brackets are equal
 */
public class BalancedBracket {
    private static final String NO = "NO", YES = "YES";

    public static void main(String[] args) {
        String[] arrays = {"[]", "[{{]})", "[[[]]]}", "({[]})", "{{{(())}}}", "[{{]})", "(){}[]", "{{{()}}}[]{{}}[][][][][][][][]", "", null};
        ArrayList<String> testme = new ArrayList(Arrays.asList(arrays));
        testme.forEach(value -> System.out.println(checkBalanceAsString(value)));
        String result[] = checkBalanceStreams(arrays);
        for (String x : result) {
            System.out.println(x);
        }
    }

    private static String[] checkBalanceStreams(String[] values) {
        String result[] = new String[values.length];
        checkAll:
        for (int i = 0; i < values.length; i++) {
            Stack<Character> stack = new Stack<>();
            try {
                String expr = values[i];
                if (null == expr || expr.length() == 1 || expr.length() == 0) {
                    result[i] = NO;
                    continue checkAll;
                }
                expr.chars().mapToObj(character -> (char) character)
                        .map(analyze -> {
                            if (analyze == '[' || analyze == '{' || analyze == '(') {
                                stack.push(analyze);
                            }
                            return analyze;
                        }).forEach(analyze -> {
                    if (!stack.empty()) {
                        char compare = stack.peek();
                        if ((compare == '[' && analyze == ']') || (compare == '{' && analyze == '}') || (compare == '(' && analyze == ')')) {
                            stack.pop();
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                });
            } catch (Exception ex) {
                result[i] = NO;
                continue checkAll;
            }
            if (stack.isEmpty()) {
                result[i] = YES;
                continue checkAll;
            } else {
                result[i] = NO;
                continue checkAll;
            }
        }
        return result;
    }

    private static String checkBalanceAsString(String wholeExpression) {
        Stack<Character> stack = new Stack<>();
        boolean inserted = false;
        if (null == wholeExpression || wholeExpression.length() == 1 || wholeExpression.length() == 0) {
            return NO;
        }
        for (int x = 0; x < wholeExpression.length(); x++) {
            char analyze = wholeExpression.charAt(x);
            if (analyze == '[' || analyze == '{' || analyze == '(') {
                inserted = true;
                stack.push(analyze);
            } else if (analyze == ']' || analyze == '}' || analyze == ')') {
                if (!stack.empty()) {
                    char compare = stack.peek();
                    if ((compare == '[' && analyze == ']') || (compare == '{' && analyze == '}') || (compare == '(' && analyze == ')')) {
                        stack.pop();
                    }
                } else {
                    return NO;
                }
            }
        }
        if (!inserted) {
            return NO;
        } else if (stack.isEmpty()) {
            return YES;
        } else {
            return NO;
        }
    }

    private static String[] checkBalanceAsArray(String[] values) {
        String result[] = new String[values.length];
        boolean inserted = false;
        checkAll:
        for (int i = 0; i < values.length; i++) {
            Stack<Character> stack = new Stack<>();
            String wholeExpression = values[i];
            if (null == wholeExpression || wholeExpression.length() == 1 || wholeExpression.length() == 0) {
                result[i] = NO;
                continue checkAll;
            }
            for (int x = 0; x < wholeExpression.length(); x++) {
                char analyze = wholeExpression.charAt(x);
                if (analyze == '[' || analyze == '{' || analyze == '(') {
                    inserted = true;
                    stack.push(analyze);
                } else if (analyze == ']' || analyze == '}' || analyze == ')') {
                    if (!stack.empty()) {
                        char compare = stack.peek();
                        if ((compare == '[' && analyze == ']') || (compare == '{' && analyze == '}') || (compare == '(' && analyze == ')')) {
                            stack.pop();
                        }
                    } else {
                        result[i] = NO;
                        continue checkAll;
                    }
                }
            }
            if (!inserted) {
                result[i] = NO;
                continue checkAll;
            } else if (stack.isEmpty()) {
                result[i] = YES;
                continue checkAll;
            } else {
                result[i] = NO;
                continue checkAll;
            }
        }
        return result;
    }
}

