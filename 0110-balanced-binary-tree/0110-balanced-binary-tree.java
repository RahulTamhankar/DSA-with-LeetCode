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

//  A tree is balanced if:

// For every node, the left and right subtrees differ in height by at most 1.


class Solution {
    public boolean isBalanced(TreeNode root) {
       return height(root) !=-1;
    }
    private int height(TreeNode node){
        if(node==null) return 0;

        int left=height(node.left);
        int right=height(node.right);

        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }

        return Math.max(left,right)+1;
    }
}
//left/right=-1 is used to early breaking

// 1. Binary Tree (BT)
// ➤ Definition:
// A binary tree is a tree data structure where each node can have at most two children: a left child and a right child.

// ✅ Rules:
// No ordering rules.

// Just focuses on structure, not values.

// ✅ Example:
// markdown
// Copy
// Edit
//       10
//      /  \
//     5    20
//    / \
//   3   8
// This is a valid binary tree, even if the values are in any order.

// \U0001f50d 2. Binary Search Tree (BST)
// ➤ Definition:
// A binary search tree is a special kind of binary tree where:

// Left child < Parent

// Right child > Parent

// This rule applies to every node in the tree.

// ✅ Example of BST:
// markdown
// Copy
// Edit
//       10
//      /  \
//     5    20
//    / \
//   3   8
// This is also a binary search tree, because:

// 5 < 10, 20 > 10

// 3 < 5, 8 > 5

// ❌ Example that is NOT a BST (but is a Binary Tree):
// markdown
// Copy
// Edit
//       10
//      /  \
//     20   5
// This is a valid binary tree, but not a BST, because:

// 20 is in the left of 10 but is greater, which breaks BST rules.