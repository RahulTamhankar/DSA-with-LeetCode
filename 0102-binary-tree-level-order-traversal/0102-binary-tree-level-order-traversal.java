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
 //TC,SC=O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        if(root==null) return list;
        queue.offer(root); //for pushing inital value 3, rest happens inside while.. Queue=[9,20],Queue=[15,7]
        while(!queue.isEmpty()){
            int levelNum=queue.size();
            List<Integer> subList=new LinkedList<Integer>();
            for(int i=0;i<levelNum;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            list.add(subList);
        }
        return list;
    }
}