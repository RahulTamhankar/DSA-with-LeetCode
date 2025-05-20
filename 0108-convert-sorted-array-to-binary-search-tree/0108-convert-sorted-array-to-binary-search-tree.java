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
        TreeNode root=new TreeNode(nums[middle]);
        root.left=MakeBST(nums,low,middle-1);
        root.right=MakeBST(nums,middle+1,high);

        return root;

    }
}

// \U0001f535 Why Choose the Middle Element?
// When building a Balanced Binary Search Tree (BST) from a sorted array:

// \U0001f9e0 Key Goals:
// BST Property: Left child < root < Right child

// Balanced Tree: Left and right subtrees of every node differ in height by at most 1

// ✅ Choosing the middle element helps us meet both goals:
// The middle value naturally splits the array into:

// Left half → smaller values (go to left subtree)

// Right half → larger values (go to right subtree)

// Example:
// java
// Copy
// Edit
// nums = [-10, -3, 0, 5, 9]
// low = 0, high = 4
// middle = (0 + 4) / 2 = 2
// nums[middle] = 0
// So:

// 0 becomes the root

// [-10, -3] go to the left subtree

// [5, 9] go to the right subtree

// This keeps the tree height-balanced and satisfies BST ordering.

// \U0001f501 Why Use middle - 1 and middle + 1 for Recursion?
// Once you've chosen the middle element (nums[middle]) as the current node/root, you don't want to include it again in the left or right subtree recursion. So you:

// For left subtree, use:

// java
// Copy
// Edit
// MakeBST(nums, low, middle - 1)
// Because middle is already used as the root, you only want to use the elements before it → from low to middle - 1.

// For right subtree, use:

// java
// Copy
// Edit
// MakeBST(nums, middle + 1, high)
// Because everything after middle should be in the right subtree → from middle + 1 to high.

