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
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode node,int currentSum){
        if(node==null){
            return 0;
        }

        currentSum=(currentSum<<1) | node.val;

        if(node.left==null && node.right==null){
            return currentSum;
        }

        return dfs(node.left,currentSum)+dfs(node.right,currentSum);
    }
}

//class Solution {
//     public int sumRootToLeaf(TreeNode root) {
//         return pathSumRootToLeaf(root, 0);
//     }

//     private int pathSumRootToLeaf(TreeNode node, int parentNodeSum) {
//         if (node == null) return 0;

//         // Update current binary number
//         parentNodeSum = 2 * parentNodeSum + node.val;

//         // If it's a leaf node, return the full number
//         if (node.left == null && node.right == null) {
//             return parentNodeSum;
//         }

//         // Recursively sum left and right subtrees
//         return pathSumRootToLeaf(node.left, parentNodeSum) +
//                pathSumRootToLeaf(node.right, parentNodeSum);
//     }
// }

// parentNodeSum = 2 * parentNodeSum + root.val;
// This line is key: it constructs the binary number as you go down the tree.

// Multiplying by 2 is the same as left-shifting (<< 1).

// Then you add the current node's value (0 or 1), just like appending a bit at the end.

// ➡️ For example:

// If the current parentNodeSum is 5 (101 in binary), and root.val is 1,
// then 2 * 5 + 1 = 11 → binary 1011.