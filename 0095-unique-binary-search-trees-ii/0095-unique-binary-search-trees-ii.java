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
            allTrees.add(null); // null subtree
            return allTrees;
        }

        // Try every number as root
        for (int i = start; i <= end; i++) {
            // All left subtrees with numbers less than i
            List<TreeNode> leftTrees = generate(start, i - 1);
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
