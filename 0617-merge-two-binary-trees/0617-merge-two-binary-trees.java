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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // If root1 is null, return root2
        if (root1 == null) return root2;
        
        // If root2 is null, return root1
        if (root2 == null) return root1;

        // Both nodes are non-null → sum the values
        TreeNode newNode = new TreeNode(root1.val + root2.val);

        // Apply the same logic recursively to the children
        if (root1.left != null || root2.left != null) {
            newNode.left = mergeTrees(root1.left, root2.left);
        }

        if (root1.right != null || root2.right != null) {
            newNode.right = mergeTrees(root1.right, root2.right);
        }

        return newNode;
    }
}
