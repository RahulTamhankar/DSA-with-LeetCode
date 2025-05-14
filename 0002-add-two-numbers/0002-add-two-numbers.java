// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode l3=new ListNode(0);
//         int carry=0;
//         ListNode head=l3;

//         while(l1 && l2){
//             int value= l1.val+l2.val+carry;
//             carry=value/10;
//             l3=l3.next;
//             l1=l1.next;
//             l2=l2.next;
//         }

//         while(l2){
//             int value= l2.val+carry;
//             carry=value/10;
//             l3=l3.next;
//             l2=l2.next;
//         }
//         while(l1){
//             int value= l1.val+carry;
//             carry=value/10;
//             l3=l3.next;
//             l1=l1.next;
//         }
//         if(carry){
//             l3.next=new ListNode(carry);
//         }
//         return head.next;
        
//     }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);  // dummy head
        ListNode head = l3;             // to return result later
        int carry = 0;

        // Process both lists as long as either has nodes
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            l3.next = new ListNode(sum % 10);
            l3 = l3.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there's a carry left after all additions
        if (carry != 0) {
            l3.next = new ListNode(carry);
        }

        return head.next;
    }
}
