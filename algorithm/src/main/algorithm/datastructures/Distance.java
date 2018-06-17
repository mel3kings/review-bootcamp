package algorithm.datastructures;

public class Distance {
    private final Edge target;
    private final double weight;

    public Distance(Edge argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }

    public Edge getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }
}