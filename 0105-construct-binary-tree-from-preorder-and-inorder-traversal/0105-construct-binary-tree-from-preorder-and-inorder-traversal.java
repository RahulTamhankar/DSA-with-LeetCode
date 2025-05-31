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

// whats this int rootVal=preorder[idx[0]];
//         idx[0]++;


// ChatGPT said:
// Great question! Let's break this down:

// \U0001f539 Line in question:
// java
// Copy
// Edit
// int rootVal = preorder[idx[0]];
// idx[0]++;
// ❓ What's going on here?
// 1. idx[0] is being used as a mutable index
// In Java, primitive types like int are passed by value, not by reference.

// But arrays are passed by reference, even if they contain just one element.

// So by wrapping an int in an array, like int[] idx = new int[]{0};, we can simulate pass-by-reference for an integer.

// 2. int rootVal = preorder[idx[0]];
// This line gets the value at the current idx from the preorder array.

// In preorder traversal, the first element is always the root of the (sub)tree being built.

// 3. idx[0]++;
// After processing the current root, move the index forward to get the next root in the preorder sequence on the next recursive call.

// \U0001f4cc Why do we need this trick?
// Java doesn’t let you pass int by reference directly. If you just did:

// java
// Copy
// Edit
// int idx = 0;
// ...then each recursive call would get its own copy of idx, and it wouldn't update the index for the next calls.

// But by doing:

// java
// Copy
// Edit
// int[] idx = new int[]{0};
// ...all recursive calls share the same idx[0], so it properly tracks the current root index across recursion.

// \U0001f501 Example:
// Given:

// java
// Copy
// Edit
// preorder = [3, 9, 20, 15, 7]
// First call: preorder[idx[0]] = 3, now idx[0] = 1

// Second call: preorder[idx[0]] = 9, now idx[0] = 2

// Third call: preorder[idx[0]] = 20, now idx[0] = 3

// ...and so on

// This ensures you're always building the tree in the correct preorder sequence.