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
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1; // left subtree not balanced

        int right = checkHeight(node.right);
        if (right == -1) return -1; // right subtree not balanced

        if (Math.abs(left - right) > 1) return -1; // current node not balanced

        return Math.max(left, right) + 1; // return height of this node
    }
}
