package easy;

import java.util.LinkedList;

public class GetTreeLevel_Ans {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if(root.left != null) {
            leftDepth = maxDepth(root.left) + 1;
        }
        if(root.right != null) {
            rightDepth = maxDepth(root.right) + 1;
        }
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;


        TreeNode left2 = new TreeNode(7);
        TreeNode right3 = new TreeNode(2);

        left.right = right3;
        right.right =left2;
        GetTreeLevel_Ans level = new GetTreeLevel_Ans();
        System.out.println(level.maxDepth(root));

    }
}


