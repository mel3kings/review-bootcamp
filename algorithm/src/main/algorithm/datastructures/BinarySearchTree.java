package algorithm.datastructures;

public class BinarySearchTree {

    public static void main(String[] args) {
        //60
        //   40        //70
        //30     //50           //90
        //15   //49
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(60, "60");
        bst.insert(40, "40");
        bst.insert(30, "30");
        bst.insert(50, "50");
        bst.insert(70, "70");
        bst.insert(90, "90");
        bst.insert(15, "15");
        bst.insert(49, "49");


        // bst.remodeNode(15);
        // bst.remodeNode(30);
        bst.remodeNode(40);
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

    /**
     * 3 possible scenarios
     * 1.) node to delete is leaf
     * 2.) node to delete is one left child
     * 3.) node has two node, where in this case we need in order successor
     *
     * @param key
     * @return
     */
    public boolean remodeNode(int key) {
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = false;
        while (currentNode.getKey() != key) {
            parentNode = currentNode;
            if (key < currentNode.getKey()) {
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            } else if (key > currentNode.getKey()) {
                isLeftChild = false;
                currentNode = currentNode.getRight();
            } else {
                return false;
            }
        }
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (isLeftChild) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else if ((currentNode.getLeft() != null && currentNode.getRight() == null) || (currentNode.getLeft() == null && currentNode.getRight() != null)) {
            if (currentNode.getLeft() != null) {
                if (isLeftChild) {
                    parentNode.setLeft(currentNode.getLeft());
                } else {
                    parentNode.setRight(currentNode.getRight());
                }
            } else if (currentNode.getRight() != null) {
                if (isLeftChild) {
                    parentNode.setLeft(currentNode.getLeft());
                } else {
                    parentNode.setRight(currentNode.getRight());
                }
            }
        } else if (currentNode.getLeft() != null && currentNode.getRight() != null) {
            Node successor = findSuccessor(currentNode.getRight());
            if (isLeftChild) {
                parentNode.setLeft(successor);
            } else {
                parentNode.setRight(successor);
            }
            successor.setLeft(currentNode.getLeft());
            successor.setRight(currentNode.getRight());
        }
        return true;
    }

    private Node findSuccessor(Node find) {
        Node parent = find;
        while (find.getLeft() != null) {
            parent = find;
            find = find.getLeft();
        }
        parent.setLeft(null);
        return find;
    }
}
