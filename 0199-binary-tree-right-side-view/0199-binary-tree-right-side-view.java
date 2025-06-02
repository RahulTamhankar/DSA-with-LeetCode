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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root); // Use offer for adding to queue

        while (!que.isEmpty()) {
            int levelSize = que.size();
            TreeNode currentNode = null; // To store the last node of the current level

            for (int i = 0; i < levelSize; i++) {
                currentNode = que.poll(); // Use poll for removing from queue

                if (currentNode.left != null) {
                    que.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    que.offer(currentNode.right);
                }
            }
            // After iterating through the current level, currentNode will be the rightmost node
            result.add(currentNode.val);
        }
        return result;
    }
}


//DFS- DO PREORDER

// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         preorder(root, 1, result);
//         return result;
//     }

//     private void preorder(TreeNode node, int level, List<Integer> result) {
//         if (node == null) return;

//         // If we're visiting this level for the first time
//         if (result.size() < level) {
//             result.add(node.val);
//         }

//         // Visit right subtree first to ensure rightmost node is visited first
//         preorder(node.right, level + 1, result);
//         preorder(node.left, level + 1, result);
//     }
// }

