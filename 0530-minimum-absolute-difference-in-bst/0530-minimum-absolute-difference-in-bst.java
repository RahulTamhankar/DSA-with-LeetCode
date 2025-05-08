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
    private Integer prev = null;           // Previous node value in in-order traversal
    private int minDiff = Integer.MAX_VALUE;  // Minimum absolute difference found so far

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);  // Start in-order DFS traversal
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        // Traverse left subtree
        inOrder(node.left);

        // Process current node
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;  // Update previous value

        // Traverse right subtree
        inOrder(node.right);
    }
}


//We don’t need Math.abs() because in a BST's in-order traversal, the values are visited in sorted ascending order. So: