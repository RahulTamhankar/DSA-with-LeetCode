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
        if(root==null) return null;

        if(root==p || root==q) return root;

        TreeNode leftN=lowestCommonAncestor(root.left,p,q);
        TreeNode rightN=lowestCommonAncestor(root.right,p,q);

        // If both sides return non-null, root is LCA
        if(leftN!=null && rightN!=null) return root;


        // Otherwise return non-null side
        if(leftN!=null){
            return leftN;
        }else{
            return rightN;  //means left==null
        }
    }
}