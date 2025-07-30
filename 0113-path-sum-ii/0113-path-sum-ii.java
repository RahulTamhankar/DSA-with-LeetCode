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
//T.C : The time complexity of the code is O(N), where N is the number of nodes in the binary tree. 
//This is because each node is visited exactly once during the recursive traversal.
//Note that I am ignoring the time taken to move the temp values to result - result.push_back(temp);
//S.C :  The space complexity is O(H) in the worst case, where H is the height of the binary tree. 
//This is due to the recursion stack during the depth-first search. In the worst case, 
//the recursion stack will have H function calls, where H is the height of the tree.
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        collectPaths(root, sum, temp, result);
        return result;
    }

    private void collectPaths(TreeNode root, int curr, List<Integer> temp, List<List<Integer>> result) {
        if (root == null)
            return;
        
        temp.add(root.val);

        if (root.left == null && root.right == null && root.val == curr) {
            result.add(new ArrayList<>(temp));
        }

        collectPaths(root.left, curr - root.val, temp, result);
        collectPaths(root.right, curr - root.val, temp, result);

        temp.remove(temp.size() - 1);
    }
}