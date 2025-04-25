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
   public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.addFirst(p.val);  // Reverse the process of preorder
            p = p.right;             // Reverse the process of preorder
        } else {
            TreeNode node = stack.pop();
            p = node.left;           // Reverse the process of preorder
        }
    }
    return result;
}
}


// Now, line-by-line breakdown:
// java
// Copy
// Edit
// public List<Integer> postorderTraversal(TreeNode root) {
//     LinkedList<Integer> result = new LinkedList<>();
// result will hold the final output. We use LinkedList so we can easily addFirst (insert at the beginning).

// java
// Copy
// Edit
//     Deque<TreeNode> stack = new ArrayDeque<>();
// We use a stack to simulate recursion (like in preorder traversal).

// java
// Copy
// Edit
//     TreeNode p = root;
// p is our current pointer.

// \U0001f501 Main loop:
// java
// Copy
// Edit
//     while(!stack.isEmpty() || p != null) {
// Continue as long as there are nodes to process.

// ✅ If current node exists:
// java
// Copy
// Edit
//         if(p != null) {
//             stack.push(p);
//             result.addFirst(p.val);  // Add value at the beginning
//             p = p.right;             // Go to right child first
//         }
// Push current node to stack.

// Add its value at the front of the result list.

// Then move to right child (not left — because we’re reversing preorder).

// \U0001f501 Otherwise, backtrack:
// java
// Copy
// Edit
//         else {
//             TreeNode node = stack.pop();
//             p = node.left;  // Now visit the left child
//         }
// When there's no right child, pop from the stack and go to left child.

// \U0001f4e5 Return result
// java
// Copy
// Edit
//     return result;
// }
// At the end, result contains the postorder traversal: Left → Right → Root

// \U0001f9e0 Summary:
// This approach does a modified preorder (Root → Right → Left) traversal, and uses addFirst() to reverse the order on-the-fly, effectively producing postorder (Left → Right → Root) traversal.

