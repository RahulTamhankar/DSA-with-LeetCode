/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

 class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> path = find_Path(p);
        while (q.parent != null) {
            for (Node node : path) {
                if (node == q) return q;
            }
            q = q.parent;
        }
        return q;
    }
    
    public List<Node> find_Path(Node p) {
        List<Node> path = new ArrayList<>();
        while (p.parent != null) {
            path.add(p);
            p = p.parent;
        }
        return path;
    }
} 










// This Java class Solution provides a method to find the Lowest Common Ancestor (LCA) of two nodes p and q in a binary tree where each node has a reference to its parent (not necessarily the root).

// \U0001f468‍\U0001f3eb Core Concept: Lowest Common Ancestor (LCA)
// In a tree, the LCA of two nodes p and q is the lowest node in the tree that has both p and q as descendants (a node can be a descendant of itself).

// \U0001f4e6 Assumed Node Class
// Although not shown, we assume a Node class like this:

// class Node {
//     int val;
//     Node left;
//     Node right;
//     Node parent;
// }
// \U0001f50d Method 1: find_Path(Node p)
// This method builds a list of all ancestors of node p, up to the root.

// public List<Node> find_Path(Node p) {
//     List<Node> path = new ArrayList<>();
//     while (p.parent != null) {
//         path.add(p);
//         p = p.parent;
//     }
//     return path;
// }
// Explanation:
// Initializes an empty list path.

// Adds node p and continues climbing up its ancestors using p = p.parent.

// Stops when it reaches the root (which has parent == null).

// Returns the list of ancestors of p, excluding the root.

// \U0001f50d Method 2: lowestCommonAncestor(Node p, Node q)
// This is the main method that finds the lowest common ancestor of nodes p and q.

// public Node lowestCommonAncestor(Node p, Node q) {
//     List<Node> path = find_Path(p);
//     while (q.parent != null) {
//         for (Node node : path) {
//             if (node == q) return q;
//         }
//         q = q.parent;
//     }
//     return q;
// }
// Explanation:
// It gets the list of all ancestors of p (excluding root) via find_Path(p).

// Then, for every ancestor of q (by climbing from q to the root), it:

// Checks if the current q is in p's ancestor path.

// If yes, this is the first common ancestor encountered — the lowest one — and it returns it.

// If no match is found before reaching the root, it returns the root.








///----------------------------------------------------------------------------------------------------
// Idea:

// This problem is the same as LC 160. Intersection of Two Linked Lists.
// Traverse up the nodes and as you hit null, switch to the other node path. When the nodes intersect, you've found the LCA
// T/S: O(d)/O(1), where d = depth of tree

// public Node lowestCommonAncestor(Node p, Node q) {
// 	var pParent = p;
// 	var qParent = q;
	
// 	while (pParent != qParent) {
// 		pParent = pParent.parent == null ? q : pParent.parent;
// 		qParent = qParent.parent == null ? p : qParent.parent;
// 	}

// 	return pParent;
// }