class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        int sum = 0;

        // Check if left child is a leaf
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }

        // Recurse on left and right children
        if (node.left != null) {
            sum += dfs(node.left);
        }
        if (node.right != null) {
            sum += dfs(node.right);
        }

        return sum;
    }
}
