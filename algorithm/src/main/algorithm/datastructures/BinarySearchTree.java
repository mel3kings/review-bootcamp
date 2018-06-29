package algorithm.datastructures;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(60, "60");
        bst.insert(40, "40");
        bst.insert(30, "30");
        bst.insert(50, "50");
        System.out.println(bst.findMin().getKey());
        System.out.println(bst.findMax().getKey());
    }

    private Node root;

    public void insert(int key, String data) {
        Node node = new Node(key, data);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeft();
                    if (null == current) {
                        parent.setLeft(node);
                        break;
                    }
                } else {
                    current = current.getRight();
                    if (null == current) {
                        parent.setRight(node);
                        break;
                    }
                }
            }
        }
    }

    public Node findMin() {
        Node current = root;
        Node last = root;
        while (current != null) {
            last = current;
            current = current.getLeft();
        }
        return last;
    }


    public Node findMax() {
        Node current = root;
        Node last = root;
        while (current != null) {
            last = current;
            current = current.getRight();
        }
        return last;
    }
}
