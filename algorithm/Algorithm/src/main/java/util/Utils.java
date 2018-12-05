package util;

import algorithm.datastructures.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Utils {
    /**
     * Generete random number
     *
     * @return
     */
    public static String randomLetter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return String.valueOf(c);
    }

    /**
     * Generate random number
     *
     * @return
     */
    public static int randomNumber() {
        int max = 20;
        int min = 1;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static Graph generateRandomGraph(int size) {
        Graph g = new Graph();
        ArrayList<Edge> list = new ArrayList<>();

        IntStream.range(0, size).forEach(i -> {
            Edge ex = new Edge("point_" + i);
            list.add(ex);
        });

        for (int counter = 0; counter < list.size(); counter++) {
            int next = counter + 1;
            int second = counter + 2;
            if (counter == list.size() - 1) {
                next = 0;
                second = 1;
            } else if (counter == list.size() - 2) {
                second = 1;
            }
            Edge currentEdge = list.get(counter);
            currentEdge.setAdjacencies(new Distance[]{new Distance(list.get(next), Utils.randomNumber())
                    , new Distance(list.get(second), Utils.randomNumber())});

        }
        g.setList(list);
        return g;
    }

    //TREE IS:
           //       A
          //   B        F
         //C       D      G
        //H  J    E
    public static Node generateRootNode() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeJ = new Node("J");
        //build the tree

        nodeC.setLeft(nodeH);
        nodeC.setRight(nodeJ);
        nodeD.setLeft(nodeE);
        nodeB.setLeft(nodeC);
        nodeB.setRight(nodeD);

        nodeF.setRight(nodeG);
        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeF);

        return nodeA;
    }


}
