package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * //
 */

class   TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class GetTreeLevel {
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        int level = 0 ;

        while(!queue.isEmpty()){
            TreeNode currentNode = queue.pop();
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if (currentNode.right != null){
                queue.add(currentNode.right);
            }

            if(null == queue.peek()){
                level +=1;
                queue.add(null);
                queue.pop();
                if(queue.peek() == null){
                    break;
                }
            }
        }
        return level;
    }



    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left= left;
        root.right= right;


        TreeNode left2 = new TreeNode(9);
        TreeNode right3 = new TreeNode(20);

        left.left = left2;
        left.right = right3;

        GetTreeLevel level = new GetTreeLevel();
        System.out.println(level.maxDepth(root));

    }


}