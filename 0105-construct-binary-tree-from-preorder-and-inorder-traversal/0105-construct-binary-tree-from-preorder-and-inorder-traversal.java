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
    Map<Integer,Integer> inorderIndexMap=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return construct(preorder,0,inorder.length-1,new int[]{0});
    }

    private TreeNode construct(int[] preorder,int l,int r,int[] idx){
        if(l>r) return null;

        int rootVal=preorder[idx[0]];
        idx[0]++;
        TreeNode root=new TreeNode(rootVal);
        int i=inorderIndexMap.get(rootVal);

        root.left=construct(preorder,l,i-1,idx);
        root.right=construct(preorder,i+1,r,idx);

        return root;
    }
}