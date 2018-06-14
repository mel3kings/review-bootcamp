package algorithm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class DjisktraAlgo {
    /**
     * generate random graph based on size
     *
     * @param n
     * @return
     */
    private static Graph generateRandomGraph(int n) {
        DjisktraAlgo dj = new DjisktraAlgo();
        DjisktraAlgo.Graph g = dj.new Graph();
        ArrayList<Edge> list = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            Edge ex = dj.new Edge("point_" + i);
            list.add(ex);
        }

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
            currentEdge.setAdjacencies(new Distance[]{dj.new Distance(list.get(next), randomNumber())
                    , dj.new Distance(list.get(second), randomNumber())});

        }
        g.setList(list);
        return g;
    }

    /**
     * generate random letter
     *
     * @return
     */
    private static String randomLetter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return String.valueOf(c);
    }

    /**
     * Generate random number
     *
     * @return
     */
    private static int randomNumber() {
        int max = 20;
        int min = 1;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * Compute all paths
     *
     * @param source
     */
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


    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("====STARTING====");
        //graph size
        int inputNumber = 10;
        Graph g = generateRandomGraph(inputNumber);
        ArrayList<Edge> l = g.getList();
        computePaths(l.get(0));
        for (Edge v : l) {
            System.out.println("Distance to " + v + " : " + v.minDistance);
            List<Edge> path = getShortestPathTo(v);
            System.out.println("Path : " + path);
        }
    }

    class Edge implements Comparable<Edge> {
        public final String name;
        private Distance[] adjacencies;
        public double minDistance = Double.POSITIVE_INFINITY;
        public Edge previous;

        public Edge(String argName) {
            name = argName;
        }

        public String toString() {
            return name;
        }

        public int compareTo(Edge other) {
            return Double.compare(minDistance, other.minDistance);
        }

        public Distance[] getAdjacencies() {
            return adjacencies;
        }

        public void setAdjacencies(Distance[] adjacencies) {
            this.adjacencies = adjacencies;
        }
    }

    class Distance {
        public final Edge target;
        public final double weight;

        public Distance(Edge argTarget, double argWeight) {
            target = argTarget;
            weight = argWeight;
        }
    }

    class Graph {
        private Edge[] edges;
        private ArrayList<Edge> list;

        public Edge[] getEdges() {
            return edges;
        }

        public void setEdges(Edge[] edges) {
            this.edges = edges;
        }

        public ArrayList<Edge> getList() {
            return list;
        }

        public void setList(ArrayList<Edge> list) {
            this.list = list;
        }

    }


}