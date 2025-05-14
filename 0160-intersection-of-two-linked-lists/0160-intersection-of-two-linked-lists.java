/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //2ptr
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lista=headA;
        ListNode listb=headB;

        while(lista!=listb){
            lista=(lista!=null) ? lista.next : headB;
            listb=(listb!=null) ? listb.next : headA;
        }
        return listb;
    }
}