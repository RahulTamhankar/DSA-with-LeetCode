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
//     int depth = 0;

//     public int minDepth(TreeNode root) {
//         if (root != null) {
//             return dfs(root, 1); // Start at depth 1
//         }
//         return 0;
//     }

//     public int dfs(TreeNode node, int depth) {
//         // If it's a leaf node
//         if (node.left == null && node.right == null) {
//             return depth;
//         }

//         int leftDepth = Integer.MAX_VALUE;
//         int rightDepth = Integer.MAX_VALUE;

//         if (node.left != null) {
//             leftDepth = dfs(node.left, depth + 1);
//         }
//         if (node.right != null) {
//             rightDepth = dfs(node.right, depth + 1);
//         }

//         return Math.min(leftDepth, rightDepth);
//     }
// }
//------------------------------------------------
//dfs
// class Solution {
//     public int minDepth(TreeNode root) {
//         if(root==null) return 0;
//         return dfs(root);
//     }
//     private int dfs(TreeNode node){
//         if(node==null) return Integer.MAX_VALUE;

//         if(node.left==null && node.right==null) return 1;

//         int left=dfs(node.left);
//         int right=dfs(node.right);

//         return 1+Math.min(left,right);
//     }
// }


//BFS---------------------------------
import java.util.*;
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;  // If the tree is empty, return depth 0

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;  // Start with depth 1 as we are at the root
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // If it's a leaf node, return the current depth
                if (node.left == null && node.right == null) {
                    return depth;
                }
                
                // Add left and right children to the queue, if they exist
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        
        return 0;  // This line will never be reached if the tree is valid
    }
}