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
// class Solution {
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         if(root==null) return false;

//         if(isSame(root,subRoot)){
//             return true;
//         }
//         return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
//     }

//     public boolean isSame(TreeNode r,TreeNode s){
//         if(r==null||s==null) return false;
//         if(s==null&&r==null) return true;
//         if(r.val!=s.val) return false;

//         return isSame(r.left,s.left) && isSame(r.right,s.right);
//     }
// }

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isSameTreeInline(root, subRoot)) {
            return true;
        }

        // Recur on left and right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTreeInline(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        return isSameTreeInline(root1.left, root2.left) && isSameTreeInline(root1.right, root2.right);
    }
}
