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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) {
            return null;
        }
        return MakeBST(nums,0,nums.length-1);
    }

    public static TreeNode MakeBST(int[] nums,int low,int high){
        if(low>high){
            return null;
        }

        int middle=(low+high)/2;
        var root=new TreeNode(nums[middle]);
        root.left=MakeBST(nums,low,middle-1);
        root.right=MakeBST(nums,middle+1,high);

        return root;

    }
}