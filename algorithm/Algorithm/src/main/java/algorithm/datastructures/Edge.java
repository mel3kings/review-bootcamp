package algorithm.datastructures;

public class Edge implements Comparable<Edge> {
    private final String name;
    private Distance[] adjacencies;
    private double minDistance = Double.POSITIVE_INFINITY;
    private Edge previous;

    public Edge(String argName) {
        name = argName;
    }

    public String toString() {
        return getName();
    }

    public int compareTo(Edge other) {
        return Double.compare(getMinDistance(), other.getMinDistance());
    }

    public Distance[] getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(Distance[] adjacencies) {
        this.adjacencies = adjacencies;
    }

    public String getName() {
        return name;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public Edge getPrevious() {
        return previous;
    }

    public void setPrevious(Edge previous) {
        this.previous = previous;
    }
}
