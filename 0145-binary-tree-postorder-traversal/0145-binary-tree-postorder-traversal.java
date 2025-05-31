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
            result.addFirst(p.val);  // Reverse the process of preorder  Note- we are doing addFirst not add hence result will have [3, 2, 1] in the end and not [1,2,3]
            p = p.right;             // Reverse the process of preorder
        } else {
            TreeNode node = stack.pop();
            p = node.left;           // Reverse the process of preorder
        }
    }
    return result;
}
}


//You’re using modified preorder traversal (Root → Right → Left) and reversing it to get postorder (Left → Right → Root).

// public List<Integer> postorderTraversal(TreeNode root) {
//     LinkedList<Integer> result = new LinkedList<>();
// result will hold the final output. We use LinkedList so we can easily addFirst (insert at the beginning).

//     Deque<TreeNode> stack = new ArrayDeque<>();
// We use a stack to simulate recursion (like in preorder traversal).

// What exactly gets popped?
// Let’s walk through a small tree:

// markdown
// Copy
// Edit
//       1
//        \
//         2
//        /
//       3
// Postorder: [3, 2, 1]

// Step-by-step:
// p = 1

// stack: [1]

// result: [1]

// move p = 1.right → p = 2

// p = 2

// stack: [1, 2]

// result: [2, 1]

// move p = 2.right → null

// p = null, enter else:

// pop 2 from stack → node = 2

// p = 2.left = 3

// p = 3

// stack: [1] (still from before)

// result: [3, 2, 1]

// p = 3.right → null

// p = null:

// pop 3 from stack → nothing left to do

// p = 3.left = null

// Keep popping:

// pop 1 from stack → p = 1.left = null

// Eventually, stack is empty, and you return result: [3, 2, 1]

// ✅ So to answer your question directly:
// java
// Copy
// Edit
// TreeNode node = stack.pop();
// It pops the most recently pushed node whose left subtree hasn't been explored yet. It’s not always the root — it depends on the traversal path. It behaves exactly like a backtracking step in DFS.

// Let me know if you want me to draw this visually too!

//     TreeNode p = root;
// p is our current pointer.

//     while(!stack.isEmpty() || p != null) {
// Continue as long as there are nodes to process.

// ✅ If current node exists:

//         if(p != null) {
//             stack.push(p);
//             result.addFirst(p.val);  // Add value at the beginning
//             p = p.right;             // Go to right child first
//         }
// Push current node to stack.

// Add its value at the front of the result list.

// Then move to right child (not left — because we’re reversing preorder).

// \U0001f501 Otherwise, backtrack:
//         else {
//             TreeNode node = stack.pop();
//             p = node.left;  // Now visit the left child
//         }
// When there's no right child, pop from the stack and go to left child.

// \U0001f4e5 Return result
//     return result;
// }
// At the end, result contains the postorder traversal: Left → Right → Root

// \U0001f9e0 Summary:
// This approach does a modified preorder (Root → Right → Left) traversal, and uses addFirst() to reverse the order on-the-fly, effectively producing postorder (Left → Right → Root) traversal.


// //\U0001f4cc What is the context?
// You’re using modified preorder traversal (Root → Right → Left) and reversing it to get postorder (Left → Right → Root).

// You're pushing nodes onto a stack and prepending (addFirst) their values to the result — this simulates postorder traversal in reverse.

// \U0001f9e0 So when you call:
// java
// Copy
// Edit
// TreeNode node = stack.pop();
// You're removing the last-pushed node from the stack — LIFO (Last In, First Out).
