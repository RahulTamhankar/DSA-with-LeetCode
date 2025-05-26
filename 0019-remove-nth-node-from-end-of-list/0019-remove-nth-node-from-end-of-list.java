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
/************************************************************ JAVA ************************************************************/
// Approach-1 (2 Pass)
// T.C : O(n)
// S.C : O(1)
// public class Solution {
//     public int lengthLinkedList(ListNode head) {
//         int l = 0;

//         while (head != null) {
//             l++;
//             head = head.next;
//         }
//         return l;
//     }

//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         int length = lengthLinkedList(head);

//         if (length == n) { // Length node from end means the first node
//             ListNode temp = head.next;
//             head = null;
//             return temp;
//         }

//         ListNode temp = head;
//         ListNode prev = null;
//         int travel = length - n;

//         while (travel-- > 0) {
//             prev = temp;
//             temp = temp.next;
//         }

//         if (prev != null) {
//             prev.next = temp.next;
//         }

//         temp = null;

//         return head;
//     }
// }


// Approach-2 (1 Pass)
// T.C : O(n)
// S.C : O(1)
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow=head;

        //fast ko n times travel karwa do
        for(int i=1;i<=n;i++){
            fast=fast.next;
        }

        if(fast==null){
            return head.next;
        }

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        ListNode temp=slow.next;
        slow.next=slow.next.next;
        temp=null;

        return head;

    }
}