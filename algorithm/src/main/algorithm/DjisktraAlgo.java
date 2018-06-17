package algorithm;


import algorithm.datastructures.Distance;
import algorithm.datastructures.Edge;
import algorithm.datastructures.Graph;
import util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class DjisktraAlgo {

    public static void main(String[] args) {
        int inputNumber = 10;
        Graph graph = generateRandomGraph(inputNumber);
        ArrayList<Edge> l = graph.getList();
        computePaths(l.get(0));
        for (Edge v : l) {
            System.out.println("Distance to " + v + " : " + v.minDistance);
            List<Edge> path = getShortestPathTo(v);
            System.out.println("Path : " + path);
        }
    }

    private static Graph generateRandomGraph(int size) {
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


    public static void computePaths(Edge source) {
        source.minDistance = 0.;
        PriorityQueue<Edge> vertexQueue = new PriorityQueue<Edge>();
        vertexQueue.add(source);
        while (!vertexQueue.isEmpty()) {
            Edge u = vertexQueue.poll();
            for (Distance e : u.getAdjacencies()) {
                Edge v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    /**
     * get shortest path
     *
     * @param target
     * @return
     */
    public static List<Edge> getShortestPathTo(Edge target) {
        List<Edge> path = new ArrayList<Edge>();
        for (Edge vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }


}