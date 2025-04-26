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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        if(root==null) return arr;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current=stack.pop();
            arr.add(current.val);
            if(current.right!=null){
                stack.push(current.right);
            }
            if(current.left!=null){
                stack.push(current.left);
            }
        }
        return arr;
    }
}

//to be processed before the right child.
// To achieve this, we push the right child first and then the left child.

// Why?

// Because left child is pushed last, so it will be popped first from the stack.

