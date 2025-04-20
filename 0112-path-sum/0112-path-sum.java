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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // If it's a leaf node, check if the path sum matches
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Subtract current node's value from target
        int remainingSum = targetSum - root.val;

        // Recurse on left and right subtree
        boolean sumLeft = hasPathSum(root.left, remainingSum);
        boolean sumRight = hasPathSum(root.right, remainingSum);

        return sumLeft || sumRight;
    }
}
