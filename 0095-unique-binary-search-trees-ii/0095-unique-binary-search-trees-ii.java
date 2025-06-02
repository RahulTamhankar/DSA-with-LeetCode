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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        
        if (start > end) {
            allTrees.add(null); // null subtree, if [1,2,3]...then for node 1 left is nothing, so for (TreeNode left : leftTrees) will never execute , which is wrong as there has to be values on the right ie 2,3. Hence its imp to add null 
            return allTrees;
        }

        // Try every number as root
        for (int i = start; i <= end; i++) {
            // All left subtrees with numbers less than i
            List<TreeNode> leftTrees = generate(start, i - 1);  //[1,2,3,4,5] for i=3 leftTrees will be 2,1 
            // All right subtrees with numbers greater than i
            List<TreeNode> rightTrees = generate(i + 1, end);

            // Combine all combinations of left and right with root i
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }
}


// Great question!

// ✅ Use of allTrees.add(null);
// This line:

// java
// Copy
// Edit
// if (start > end) {
//     allTrees.add(null);
//     return allTrees;
// }
// is crucial to correctly generate empty subtrees, which are valid and necessary when building Binary Search Trees (BSTs).

// \U0001f50d Why do we add null to the list?
// When generating trees, not every node will have both left and right children. Some may have:

// only a left child,

// only a right child,

// or no children at all (i.e., null).

// So when start > end, there are no nodes to build a subtree. In that case:

// We must still return a list so that the parent node (in recursion) can try this case.

// That list should contain a single null to represent an empty subtree.

// This null becomes a valid child in:

// java
// Copy
// Edit
// for (TreeNode left : leftTrees) {
//     for (TreeNode right : rightTrees) {
//         TreeNode root = new TreeNode(i);
//         root.left = left;   // could be null
//         root.right = right; // could be null
//         allTrees.add(root);
//     }
// }
// \U0001f914 What happens if we don’t add null?
// Then the recursive combination breaks. For example, take:

// text
// Copy
// Edit
// generate(1, 1)
// This would try:

// i = 1 → left subtree = generate(1, 0), right subtree = generate(2, 1)

// If generate(1, 0) returns an empty list, the loop:

// java
// Copy
// Edit
// for (TreeNode left : leftTrees)
// won’t run at all, and no tree gets created, even though a valid one like:

// Copy
// Edit
//   1
// should exist.

// \U0001f9e0 Analogy:
// Adding null is like saying:

// "This side has nothing, but that's still a valid configuration."

