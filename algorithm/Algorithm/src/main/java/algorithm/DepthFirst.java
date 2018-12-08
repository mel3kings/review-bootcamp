package algorithm;

import algorithm.datastructures.Node;
import util.Utils;

import java.util.Optional;
import java.util.Stack;

public class DepthFirst {

    //TREE IS:
    //       A
    //   B        F
    //  C       D      G
    //H  J    E
    public static void main(String[] args) {
        Node node = Utils.generateRootNode();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node found = DFS(stack, node, "E");
        Optional.ofNullable(found).ifPresent(result->System.out.println("found DATA: "+ result.getData()));
    }

    public static Node DFS(Stack<Node> stack, Node currentNode, String findMe) {
        System.out.println("VISITING: " + currentNode.getData());
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
}
