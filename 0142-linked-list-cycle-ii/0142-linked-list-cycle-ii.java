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
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
        
//     }
// }

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean cycleFound = false;

        // Step 1: Detect cycle using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) {
                cycleFound = true;
                break;
            }
        }

        // Step 2: If no cycle found
        if (!cycleFound) {
            return null;
        }

        // Step 3: Find the start node of the cycle
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // or fast, both are now at the start of the cycle
    }
}
