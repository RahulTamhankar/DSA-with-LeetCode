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
    public boolean findTarget(TreeNode root, int k) {
       HashSet<Integer> set=new HashSet<>();
       return dfs(root,k,set);
    }

    private boolean dfs(TreeNode node,int k, HashSet<Integer> set){
        if(node==null){
            return false;
        }   
        if(set.contains(k-node.val)){
            return true;
        }
        set.add(node.val);

        boolean left=dfs(node.left,k,set);
        boolean right=dfs(node.right,k,set);
        
        return left || right;
    }
}