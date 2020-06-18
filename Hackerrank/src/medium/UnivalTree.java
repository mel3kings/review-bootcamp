package medium;

public class UnivalTree {
//        2
//      1   3
//        3   3
    public static void main(String[] args) {
        Node left = new Node("1");
        Node right = new Node("3");
        Node root = new Node("3", left, right);
        System.out.println("is balance "+ isBalance(root));
        Node rightChild = new Node("3");
        Node secondRightChild = new Node("3");
        right.left = rightChild;
        right.right = secondRightChild;
        System.out.println("node is unival " + isUnival(root));
        System.out.println("is balance "+ isBalance(root));
    }

    public static boolean isUnival(Node node) {
        if (node == null || node.val.equals("")) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        if ((node.left != null && !node.val.equals(node.left.val)) || (node.right != null && !node.val.equals(node.right.val))) {
            return false;
        }
        return isUnival(node.left) && isUnival(node.right);
    }

    public static boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }

        if (node.left != null && node.right == null){
            return false;
        } else if (node.right != null && node.left == null) {
            return false;
        } else if (node.left == null && node.right == null) {
            return true;
        }
        return isBalance(node.left) && isBalance(node.right);
    }
}


class Node {
    String val;
    Node left;
    Node right;

    public Node(String val) {
        this.val = val;
    }

    public Node(String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
