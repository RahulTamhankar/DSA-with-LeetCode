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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        return (p.val==q.val) &&
            isSameTree(p.left,q.left) && 
            isSameTree(p.right,q.right);
    }
}


// Visual Walkthrough:
// Example 1: Same Tree
// plaintext
// Copy
// Edit
// p:          q:
//     1           1
//    / \         / \
//   2   3       2   3
// p.val == q.val → 1 == 1 → true

// Recursively check left and right:

// Left subtrees: 2 == 2 → true

// Right subtrees: 3 == 3 → true

// All checks pass → return true.

// Example 2: Different Structure
// plaintext
// Copy
// Edit
// p:          q:
//     1           1
//    /             \
//   2               2
// p.val == q.val → 1 == 1 → true

// Recursively check left and right:

// Left of p is 2, but right of q is null → not same → return false.

