package algorithm;

import algorithm.datastructures.Node;
import util.Utils;

import java.util.Stack;

public class DepthFirst {

    //TREE IS:
    //       A
    //   B        F
    //  C       D      G
    //H  J    E
    public static void main(String[] args){
       Node node = Utils.generateRootNode();
       Stack<Node> stack = new Stack<>();
       stack.push(node);
       DFS(stack);

    }

    public static void DFS(Stack<Node> stack){
        while(!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.println("VISITING: " + currentNode.getData());

            if(currentNode.getRight() != null){
                stack.push(currentNode.getRight());
            }
            if (currentNode.getLeft() != null) {
                stack.push(currentNode.getLeft());
            }
            DFS(stack);
        }
    }
}
