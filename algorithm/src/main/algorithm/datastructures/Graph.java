package algorithm.datastructures;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<Edge> list;

    public ArrayList<Edge> getList() {
        return list;
    }

    public void setList(ArrayList<Edge> list) {
        this.list = list;
    }

    public void print(){
        list.stream().forEach( edge ->{
            System.out.println(edge.getName() + " -> ");
            Arrays.stream(edge.getAdjacencies()).forEach(distance -> System.out.print(distance.getTarget() + " weight: " + distance.getWeight() + " ,"));
            System.out.println("");
        });
    }

}