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

// Time complexity: O(n)
// Space complexity: O(1) (in-place)
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;

                // Find the rightmost node of the left subtree
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Connect the right subtree to the rightmost node of the left subtree
                prev.right = curr.right;

                // Move the left subtree to the right
                curr.right = curr.left;
                curr.left = null;
            }

            // Move to the next node (right child)
            curr = curr.right;
        }
    }
}

// Time Complexity: O(n) (each node visited once)
// Space Complexity: O(h) (height of tree — max size of stack)
// class Solution {
//     public void flatten(TreeNode root) {
//         if (root == null) return;

//         Stack<TreeNode> st = new Stack<>();
//         st.push(root);

//         while (!st.isEmpty()) {
//             TreeNode curr = st.pop();

//             // Push right child first so that left is processed first
//             if (curr.right != null) {
//                 st.push(curr.right);
//             }

//             if (curr.left != null) {
//                 st.push(curr.left);
//             }

//             // Set the current node's right to the next node on stack (preorder)
//             if (!st.isEmpty()) {
//                 curr.right = st.peek();
//             }

//             // Set left to null to flatten
//             curr.left = null;
//         }
//     }
// }
