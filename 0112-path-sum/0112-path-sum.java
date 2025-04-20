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
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if(root==null){
//             return false;
//         }

//         if(root.left==null && root.right==null){
//             return targetSum==root.val;
//         }

//         int remainingSum=targetSum-root.val;
        
//         boolean left=hasPathSum(root.left,remainingSum);
//         boolean right=hasPathSum(root.right,remainingSum);

//         return left || right;
//     }
// }

// Why targetSum == root.val at a leaf?
// Let’s say we’re at a leaf node (a node with no children), and we’ve been subtracting values from targetSum on our way down. At this point:

// If the remaining targetSum is exactly equal to the leaf’s value,

// That means the whole path added up correctly.


//---------------------
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkPath(root, 0, targetSum);
    }

    private boolean checkPath(TreeNode node, int currentSum, int targetSum) {
        if (node == null) return false;

        // Add the current node's value to the running sum
        currentSum += node.val;

        // If it's a leaf node, check if the path sum matches
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }

        // Recurse left and right with updated sum
        return checkPath(node.left, currentSum, targetSum) ||
               checkPath(node.right, currentSum, targetSum);
    }
}

