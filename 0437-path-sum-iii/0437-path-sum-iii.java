/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // Count paths starting at root
        int countFromRoot = countPaths(root, targetSum);

        // Recurse left and right
        int countFromLeft = pathSum(root.left, targetSum);
        int countFromRight = pathSum(root.right, targetSum);

        return countFromRoot + countFromLeft + countFromRight;
    }

    private int countPaths(TreeNode node, long targetSum) {
        if (node == null) return 0;

        int count = 0;
        if (node.val == targetSum) count++;

        count += countPaths(node.left, targetSum - node.val);
        count += countPaths(node.right, targetSum - node.val);

        return count;
    }
}

