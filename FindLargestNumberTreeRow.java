import java.util.*;
import java.util.LinkedList;

//Time -> O(N) -> visiting every single node 
//Space -> O(H) -> worst case we will have all the nodes of the leaves in the queue.
//LeetCode: https://leetcode.com/problems/find-largest-value-in-each-tree-row/

/**
 * Finds the largest value in each row of a binary tree.
 * Performs level-order traversal using a queue to process nodes level by level.
 * Returns a list of the maximum values for each level in top-down order.
 */
public class FindLargestNumberTreeRow {
     // Definition for a binary tree node.
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size ; i++) {
                TreeNode currNode = q.poll(); 
                max = Math.max(max, currNode.val);

                if(currNode.left != null) {
                    q.offer(currNode.left);
                }

                if(currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
