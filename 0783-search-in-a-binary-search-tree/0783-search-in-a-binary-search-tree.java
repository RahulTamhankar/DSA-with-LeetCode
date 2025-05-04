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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp.val==val){
                return temp;
            }
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return null;
    }
}
// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//         //base condition
//         if(root == null || root.val == val)return root;
       
//         // Travel in the tree;
//         if(root.val > val){
//             root = searchBST(root.left,val);
//         }else{
//             root = searchBST(root.right,val);
//         }

//         // If the value doesn't exist return null
//         return root;
//     }
// }
// //There are three cases:

// ✅ Equal: v == val → Found the node → return it.

// \U0001f53d Less than: val < v → The target must be in the left subtree.

// \U0001f53c Greater than: val > v → The target must be in the right subtree.