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
    private int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode node){
        if(node==null) return 0; 

        int leftDepth=helper(node.left);
        int rightDepth=helper(node.right);

        int currentDiameter=leftDepth+rightDepth;

        diameter=Math.max(diameter,currentDiameter);

        return Math.max(leftDepth,rightDepth)+1;
    }
}

//This return value is the height (depth) of the current node’s subtree.

// It’s used by the parent node to calculate its own depth.

// It's not the diameter — just the depth of the longest path down from this node to a leaf.


//Mistake done 
// public void helper(TreeNode node){
// 	if(node.left==null || node.right==null) return null;

//      1
//        / \
//       2   3
//      / \
//     4   5
// Longest path: [4 → 2 → 1 → 3]

// Number of edges = 3 → that's the diameter

// Let’s Trace at Node 1:
// leftDepth = depth of node 2 = 2 (2 → 4 or 5)

// rightDepth = depth of node 3 = 1

// currentDiameter = 2 + 1 = 3

// ✅ Yes, that’s correct — and it matches the actual diameter of the tree.


