package algorithm;

import algorithm.datastructures.Node;
import util.Utils;

import java.util.LinkedList;
import java.util.Queue;


public class BreadthFirst {
    //TREE IS:
    //       A
    //   B        F
    //  C       D      G
    //H  J    E
    public static void main(String args[]) {
       Node root =  Utils.generateRootNode();
       LinkedList<Node> queue = new LinkedList<>();
       queue.offer(root);
       BFS(queue);
    }
    // Should output A,B,F,C,D,G,E
    public static void BFS(Queue<Node> queue){
       while(!queue.isEmpty()){
           Node current = queue.poll();
           System.out.println("VISITING: " + current.getData());

           if(current.getLeft() != null){
               queue.add(current.getLeft());
           }
           if(current.getRight() != null){
               queue.add(current.getRight());
           }
           BFS(queue);
       }
    }
}
