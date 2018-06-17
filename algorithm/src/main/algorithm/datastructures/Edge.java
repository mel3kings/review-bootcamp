package algorithm.datastructures;

public class Edge implements Comparable<Edge> {
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
