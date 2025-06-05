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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            double sum=0;

            for(int i=0;i<size;i++){
                TreeNode current=queue.poll();
                sum+=current.val;

                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
            result.add(sum/size);
        }
        return result;
    }
}

// BFS Level Order Traversal
// Input Tree:

// markdown
// Copy
// Edit
//        3
//      /   \
//     9     20
//          /  \
//         15   7
// \U0001f9e0 Initialization:
// queue = [3]

// result = []

// ✅ Level 0
// size = 1 → Only 1 node: 3

// sum = 0

// \U0001f501 Loop runs 1 time (since size is 1):

// current = 3

// sum += 3 → sum = 3

// queue.offer(3.left) → queue becomes [9]

// queue.offer(3.right) → queue becomes [9, 20]

// ✅ After loop:

// result.add(3.0)

// queue = [9, 20]

// ✅ Level 1
// size = 2 → Nodes: 9, 20

// sum = 0

// \U0001f501 Loop runs 2 times:

// \U0001f539 1st Iteration:
// current = 9

// sum += 9 → sum = 9

// 9.left == null, 9.right == null → queue = [20]

// \U0001f539 2nd Iteration:
// current = 20

// sum += 20 → sum = 29

// queue.offer(20.left) → queue becomes [15]

// queue.offer(20.right) → queue becomes [15, 7]

// ✅ After loop:

// result.add(14.5)

// queue = [15, 7]

// ✅ Level 2
// size = 2 → Nodes: 15, 7

// sum = 0

// \U0001f501 Loop runs 2 times:

// \U0001f539 1st Iteration:
// current = 15

// sum += 15 → sum = 15

// \U0001f539 2nd Iteration:
// current = 7

// sum += 7 → sum = 22

// ✅ After loop:

// result.add(11.0)

// queue = [] → Done

// ✅ Final Result:
// java
// Copy
// Edit
// [3.0, 14.5, 11.0]