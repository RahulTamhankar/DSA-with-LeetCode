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
//     public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res=new ArrayList<>();
//        helper(root,res);
//        return res; 
//     }
//     public void helper(TreeNode root,List<Integer> res){
//         if(root!=null){
//             helper(root.left,res);
//             res.add(root.val);
//             helper(root.right,res);
//         }
//     }
// }

//Dfs InOrder- Go to Left node->Add Root Node->Go to Right node

//Iterative stack 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        while(root!=null || !stack.isEmpty()){//
            while(root!=null){
                stack.push(root);  // Go left
                root=root.left;
            }

            root=stack.pop();      // Visit root
            res.add(root.val);
            root=root.right;       // Go right
        }

        return res;
    }
}
// Why You Need the Inner Loop
// Even though the outer loop checks root != null, that’s just to keep the traversal running. The inner loop is what actually goes down the tree to the leftmost node.

// Without the inner loop:
// You’d only go one level left per iteration — you wouldn’t be traversing deeply to the left before visiting nodes.

//Stack push and list push denote ->LEFT
//Poppping and visiting stack denote->ROOT


//  What is In-Order Traversal?
// In a binary tree, in-order traversal visits nodes in the order:


//“Go as left as possible by pushing all left children onto the stack. Once you hit null, pop the top from the stack (that’s the ROOT), visit it, then move to its RIGHT child. Repeat.”
// css
// Copy
// Edit
// LEFT → ROOT → RIGHT
// Example Tree:

// markdown
// Copy
// Edit
//     1
//    / \
//   2   3
// In-order traversal: 2 → 1 → 3

// \U0001f9e0 Intuition Behind the Code
// In a recursive approach, we do:

// java
// Copy
// Edit
// inorder(root.left);
// visit(root);
// inorder(root.right);
// But here, we’re using a stack to simulate that recursion manually, so we can traverse iteratively.

// \U0001f50d Breakdown of the Code:
// java
// Copy
// Edit
// List<Integer> res = new ArrayList<>();
// Stack<TreeNode> stack = new Stack<>();
// We need a result list and a stack to keep track of the nodes we need to revisit (like the call stack in recursion).

// \U0001f501 Outer loop:
// java
// Copy
// Edit
// while (root != null || !stack.isEmpty())
// This keeps running:

// While there are nodes left to explore (root ≠ null), OR

// There are nodes we've saved to revisit later (stack not empty)

// ⬅️ Inner loop — going left as far as possible:
// java
// Copy
// Edit
// while (root != null) {
//     stack.push(root);
//     root = root.left;
// }
// This is equivalent to the recursive call:

// java
// Copy
// Edit
// inorder(root.left);
// We push the current node because we’ll need to come back and visit it after exploring the left subtree.

// ✅ After left is done, we:
// java
// Copy
// Edit
// root = stack.pop();       // Visit root
// res.add(root.val);        // Add root value to result
// root = root.right;        // Explore right subtree
// This corresponds to:

// java
// Copy
// Edit
// visit(root);
// inorder(root.right);
