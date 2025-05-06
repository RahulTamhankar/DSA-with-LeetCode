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
    int currNum = 0;
    int currFreq = 0;
    int maxFreq = 0;
    private List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        currNum = Integer.MIN_VALUE; // to handle negative values safely
        dfs(root);

        // Convert result list to array
        int[] modes = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            modes[i] = result.get(i);
        }
        return modes;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        // In-order traversal: left -> node -> right
        dfs(node.left);

        // Visit current node
        if (node.val == currNum) {
            currFreq++;
        } else {
            currNum = node.val;
            currFreq = 1;
        }

        if (currFreq > maxFreq) {
            result.clear();
            result.add(currNum);
            maxFreq = currFreq;
        } else if (currFreq == maxFreq) {
            result.add(currNum);
        }

        dfs(node.right);
    }
}


//Inorder traversal
//Left-->do something-->right