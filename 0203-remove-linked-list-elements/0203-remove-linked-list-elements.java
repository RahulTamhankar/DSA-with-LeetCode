/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //Recursion goes to the end of the list first.

// It builds the result list in reverse order, fixing next pointers as it returns.

// Nodes with val are skipped (not linked back).
// class Solution {
//     public ListNode removeElements(ListNode head, int val) {
//         if(head==null) return null;
//         if(head.val==val) return removeElements(head.next,val);

//         head.next=removeElements(head.next,val);
//         return head;

//     }
// }
//----------------------
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null){
            if (curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}