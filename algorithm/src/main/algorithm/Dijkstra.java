package algorithm;

import algorithm.datastructures.Distance;
import algorithm.datastructures.Edge;
import algorithm.datastructures.Graph;
import util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void main(String[] args){
        int size = 7 ;
        Graph graph= Utils.generateRandomGraph(size);
        graph.print();
        List<Edge> list = graph.getList();
        List<Edge> path = getShortestPathTo(compute(list.get(0),list.get(size-1)));
        System.out.println("Path : " + path);
    }

    public static Edge compute(Edge start, Edge destination){
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        start.setMinDistance(0.); //set self to 0 as the minDistance to self is already 0
        queue.add(start);
        while(!queue.isEmpty()){
            Edge currentEdge = queue.poll();
            for(Distance d : currentEdge.getAdjacencies()){
                Edge target = d.getTarget();
                queue.add(target);
                double distanceWeight =  currentEdge.getMinDistance() + d.getWeight();
                //we keep updating the minDistance of a target edge based on who is hitting it from the adjacents,
                // ie. edge 4, couldve been visited by 1,2,3 and 1,3
                // if distance weight now is currently less then target minDistance, it means this is the lower path
                if(distanceWeight < target.getMinDistance()){
                    target.setMinDistance(distanceWeight);
                    target.setPrevious(currentEdge);
                }

                if(destination.equals(target)){
                    return target;
                }
            }
        }
        return null;
    }

    /**
     * hence after computing the shortest path, we just keep getting hte previous vertex
     * @param target
     * @return
     */
    public static List<Edge> getShortestPathTo(Edge target) {
        List<Edge> path = new ArrayList<Edge>();
        for (Edge vertex = target; vertex != null; vertex = vertex.getPrevious())
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }
}
