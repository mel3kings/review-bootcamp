package medium;

import java.util.*;

public class ZigZagTraversal {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> lef = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rig = new LinkedList<TreeNode>();
        lef.offer(root);
        traverse(lef, rig);
        return result;
    }

    public void traverse(LinkedList<TreeNode> lef, LinkedList<TreeNode> rig) {
        TreeNode process = null;
        List<Integer> sub = new ArrayList<>();
        while (!lef.isEmpty()) {
            process = lef.poll();
            if (process == null) {
                continue;
            }
            sub.add(process.val);
            if (process.left != null) {
                rig.offerFirst(process.left);
            }
            if (process.right != null) {
                rig.offerFirst(process.right);
            }
        }
        if (sub.size() > 0) {
            result.add(sub);

        }
        sub = new ArrayList<>();
        while (!rig.isEmpty()) {
            process = rig.poll();
            if (process == null) {
                continue;
            }
            sub.add(process.val);
            if (process.right != null) {
                lef.offerFirst(process.right);
            }
            if (process.left != null) {
                lef.offerFirst(process.left);
            }
        }
        if (sub.size() > 0) {
            result.add(sub);
        }
        if (!lef.isEmpty() || !rig.isEmpty()) {
            traverse(lef, rig);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
