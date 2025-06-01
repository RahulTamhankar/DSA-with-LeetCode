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
//     public int pathSum(TreeNode root, int targetSum) {
//         if (root == null) return 0;

//         // Count paths starting at root
//         int countFromRoot = countPaths(root, targetSum);

//         // Recurse left and right
//         int countFromLeft = pathSum(root.left, targetSum);
//         int countFromRight = pathSum(root.right, targetSum);

//         return countFromRoot + countFromLeft + countFromRight;
//     }

//     private int countPaths(TreeNode node, long targetSum) {
//         if (node == null) return 0;

//         int count = 0;
//         if (node.val == targetSum) count++;

//         count += countPaths(node.left, targetSum - node.val);
//         count += countPaths(node.right, targetSum - node.val);

//         return count;
//     }
// }

//Optimal --------------------------------------------------
// NOTE- If I dont use long I will get wrong ans Input
// root =
// [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
// targetSum =
// 0

// Use Testcase
// Output
// 2
// Expected
// 0
// What's happening?
// Your tree node values can be as large as 1,000,000,000 (10^9), and you accumulate sums along the path.

// If you use int for currSum, it will overflow since int max is about 2*10^9.

// Overflow causes incorrect sums and wrong map keys, so the counts get messed up — leading to wrong answers.

// Why does this happen?
// For example, if currSum goes beyond Integer.MAX_VALUE (2,147,483,647), it wraps around to negative or incorrect values.

// How to fix?
// Change the type of currSum and the prefix sum map keys to long (64-bit integer), which can safely handle sums up to about 9*10^18.

// class Solution {
//     public int pathSum(TreeNode root, int targetSum) {
//         Map<Integer, Integer> prefixSumCount = new HashMap<>();
//         prefixSumCount.put(0, 1); // Base case: one way to get sum 0
//         return dfs(root, 0, targetSum, prefixSumCount);
//     }

//     private int dfs(TreeNode node, int currSum, int target, Map<Integer, Integer> prefixSumCount) {
//         if (node == null) return 0;

//         currSum += node.val;

//         // Number of valid paths ending at current node
//         int count = prefixSumCount.getOrDefault(currSum - target, 0);

//         // Update map with current prefix sum
//         prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

//         // Explore children
//         count += dfs(node.left, currSum, target, prefixSumCount);
//         count += dfs(node.right, currSum, target, prefixSumCount);

//         // Backtrack: remove current prefix sum before returning
//         prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

//         return count;
//     }
// }


class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Base case: one way to get sum 0
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currSum += node.val;

        int count = prefixSumCount.getOrDefault(currSum - target, 0);

        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, target, prefixSumCount);
        count += dfs(node.right, currSum, target, prefixSumCount);

        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return count;
    }
}
