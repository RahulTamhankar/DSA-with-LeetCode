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
//We'll do in-order traversal using a stack (left → root → right).       
//pre will store the previously visited node (we compare it with the current).


class Solution {      
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            //go as left as possible and then visit at the top of stack(current root)
            root=stack.pop();
            if(pre!=null && root.val<=pre.val) return false;
            pre=root;
            root=root.right;
        }        
        return true;
    }                
}                    

// class Solution {
//     TreeNode prev;
        
//     public boolean isValidBST(TreeNode root) {
//         if (root == null)
//             return true;
        
//         if(!isValidBST(root.left))
//             return false;
        
//         if (prev != null && prev.val >= root.val)
//             return false;
        
//         prev = root;
        
//         if (!isValidBST(root.right))
//             return false;
        
//         return true;
        
        
//     }
// }