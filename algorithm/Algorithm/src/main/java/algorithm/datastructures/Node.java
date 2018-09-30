package algorithm.datastructures;


public class Node {
    private int key;
    private String data;
    private Node left;
    private Node right;
    private boolean isVisited;

    public Node(String data) {
        this.data = data;
    }

    public Node(int key, String data){
        this.key = key;
        this.data = data;
    }
    public Node() {

    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
