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
    Map<Integer,List<TreeNode>> dp=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
       if(n%2==0) return new ArrayList<>();

       if(n==1) return Arrays.asList(new TreeNode(0));

       if(dp.containsKey(n)) return dp.get(n);

       List<TreeNode> ans=new ArrayList<>();

       for(int i=1;i<n;i++){
        List<TreeNode> left=allPossibleFBT(i);
        List<TreeNode> right=allPossibleFBT(n-i-1);

        for(TreeNode l:left){
            for(TreeNode r:right){
                TreeNode root=new TreeNode(0);
                root.left=l;
                root.right=r;
                ans.add(root);
            }
        }
       }
       dp.put(n,ans);
       return ans;
    }
}
