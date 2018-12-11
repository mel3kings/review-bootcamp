package algorithm;

import algorithm.datastructures.Node;
import util.Utils;

import java.util.Optional;
import java.util.Stack;

public class DepthFirst {

    //TREE IS:
    //       A
    //   B        F
    //  C   D        G
    //H  J E
    public static void main(String[] args) {
        Node node = Utils.generateRootNode();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node found = DFS(stack, node, "G");
        Node found2 = DepthFirstSearch(stack, "X");
        Optional.ofNullable(found2).ifPresent(result -> System.out.println("found DATA: " + result.getData()));
    }

    public static Node DFS(Stack<Node> stack, Node currentNode, String findMe) {
        System.out.println("first method: " + currentNode.getData());
        if (null != currentNode && currentNode.getData().equals(findMe)) {
            return currentNode;
        } else if (!stack.isEmpty()) {
            if (null != currentNode.getRight()) {
                stack.push(currentNode.getRight());
            }
            if (null != currentNode.getLeft()) {
                stack.push(currentNode.getLeft());
            }
            return DFS(stack, stack.pop(), findMe);
        } else {
            return null;
        }
    }


    public static Node DepthFirstSearch(Stack<Node> stack, String find) {
        Node currentNode = stack.pop();
        System.out.println("second method: " + currentNode.getData());
        if (null != currentNode && currentNode.getData().equals(find)) {
            return currentNode;
        } else if (!stack.isEmpty() || currentNode.getLeft() != null || currentNode.getRight() != null) {

            if (currentNode.getRight() != null) {
                stack.push(currentNode.getRight());
            }
            if (currentNode.getLeft() != null) {
                stack.push(currentNode.getLeft());
            }
            return DepthFirstSearch(stack, find);
        } else {
            return null;
        }
    }

}
