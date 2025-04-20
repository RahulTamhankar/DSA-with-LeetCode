/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Start from root and traverse down the tree
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left; // both nodes are smaller, go left
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right; // both nodes are greater, go right
            } else {
                return root; // One node is on each side → this is the LCA
            }
        }
        return null; // Just in case
    }
}
