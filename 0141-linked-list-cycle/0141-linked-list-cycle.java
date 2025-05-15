/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}


// We did this in finding middle element fast == null || fast.next == null,
// But In the cycle detection version:

// You’re not interested in the middle.

// You're checking whether slow == fast, which would only happen if there's a loop (they'll keep chasing each other in the cycle until they meet).

//A map is a BST, unordered_map is a hast table.
// insertions and lookup have an O(logn) time complexity in a map and O(1) in an unordered_map

