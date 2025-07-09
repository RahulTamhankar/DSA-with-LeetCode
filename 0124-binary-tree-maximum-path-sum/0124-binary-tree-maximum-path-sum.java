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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE; // initialize to the smallest integer
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate max gain from left and right children
        int leftGain = Math.max(dfs(node.left), 0); // ignore negative paths
        int rightGain = Math.max(dfs(node.right), 0);

        // Calculate the max path sum with the current node as the highest node (root of this path)
        int currentPathSum = node.val + leftGain + rightGain;

        // Update global maxSum if currentPathSum is greater
        maxSum = Math.max(maxSum, currentPathSum);

        // Return max gain to parent (can only include one child + current node)
        return node.val + Math.max(leftGain, rightGain);
    }
}
