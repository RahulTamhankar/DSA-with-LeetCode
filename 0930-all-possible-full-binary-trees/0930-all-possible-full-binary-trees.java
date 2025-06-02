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
//     public List<TreeNode> allPossibleFBT(int n) {
//         if (n % 2 == 0) return new ArrayList<>(); // Full BTs only have odd number of nodes

//         List<TreeNode> ans = new ArrayList<>();
//         if (n == 1) {
//             ans.add(new TreeNode(0));
//             return ans;
//         }

//         for (int i = 1; i < n; i += 2) {
//             List<TreeNode> leftTrees = allPossibleFBT(i);
//             List<TreeNode> rightTrees = allPossibleFBT(n - 1 - i);

//             for (TreeNode left : leftTrees) {
//                 for (TreeNode right : rightTrees) {
//                     TreeNode root = new TreeNode(0);
//                     root.left = left;
//                     root.right = right;
//                     ans.add(root);
//                 }
//             }
//         }

//         return ans;
//     }
// }

//Optimal
class Solution {
    Map<Integer, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        // if (n % 2 == 0) return new ArrayList<>();  // Full Binary Trees must have odd number of nodes
        if (n == 1) return Arrays.asList(new TreeNode(0)); // ok even if we dont give 0, as in the top constructor new node is initialized with 0

        if (dp.containsKey(n)) return dp.get(n);

        List<TreeNode> ans = new ArrayList<>();

        for (int i = 1; i < n; i+=2) { 
            List<TreeNode> left = allPossibleFBT(i);  //for n=5, 1 is root, 1 is for left hence i and 3 is on right hence 5-1-1;
            List<TreeNode> right = allPossibleFBT(n - i - 1);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }

        dp.put(n, ans);
        return ans;
    }
}
