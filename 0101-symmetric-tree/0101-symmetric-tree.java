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
    public boolean isTreeSymmetric(TreeNode leftRoot,TreeNode rightRoot){
        if(leftRoot==null && rightRoot==null)
            return true;
        if((leftRoot==null && rightRoot!=null) || 
            (leftRoot!=null && rightRoot==null))
            return false;
        if(leftRoot.val!=rightRoot.val)
            return false;
        return isTreeSymmetric(leftRoot.left,rightRoot.right)
                && isTreeSymmetric(leftRoot.right,rightRoot.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isTreeSymmetric(root.left,root.right);
    }
}


//Iterative 
//import java.util.*;

// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if (root == null)
//             return true;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root.left);
//         q.offer(root.right);

//         while (!q.isEmpty()) {
//             TreeNode leftRoot = q.poll();
//             TreeNode rightRoot = q.poll();

//             if (leftRoot == null && rightRoot == null)
//                 continue;

//             if ((leftRoot == null && rightRoot != null) || 
//                 (leftRoot != null && rightRoot == null))
//                 return false;

//             if (leftRoot.val != rightRoot.val)
//                 return false;

//             q.offer(leftRoot.left);
//             q.offer(rightRoot.right);
//             q.offer(leftRoot.right);
//             q.offer(rightRoot.left);
//         }

//         return true;
//     }
// }
