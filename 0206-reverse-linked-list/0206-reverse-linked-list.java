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
class Solution {
    public ListNode reverseList(ListNode head) {
                ListNode res=null;

        if(head==null || head.next==null) return head;

        res=reverseList(head.next);

        head.next.next=head;

        head.next=null;

        return res;
    } 
}

//Visual Walkthrough with Example
// Let’s reverse this list:

// bash
// Copy
// Edit
// head → 1 → 2 → 3 → 4 → 5 → null
// \U0001f9e0 Step-by-Step Breakdown (Recursive Unfolding)
// \U0001f3af Goal: Reverse the list to:
// csharp
// Copy
// Edit
// 5 → 4 → 3 → 2 → 1 → null
// \U0001f504 Recursive Breakdown:
// Call stack as recursion goes down:
// java
// Copy
// Edit
// reverseList(1) → calls reverseList(2)
// reverseList(2) → calls reverseList(3)
// reverseList(3) → calls reverseList(4)
// reverseList(4) → calls reverseList(5)
// reverseList(5) → returns 5 (base case)
// ⏪ Recursion unwinds (steps backward):
// Now we reverse the pointers from bottom to top:

// Step: From reverseList(4)
// java
// Copy
// Edit
// head = 4
// head.next = 5

// head.next.next = head; // 5 → 4
// head.next = null;      // 4 → null
// ✅ Now: 5 → 4 → null

// Step: From reverseList(3)
// java
// Copy
// Edit
// head = 3
// head.next = 4

// head.next.next = head; // 4 → 3
// head.next = null;      // 3 → null
// ✅ Now: 5 → 4 → 3 → null

// Keep going...
// Eventually:

// csharp
// Copy
// Edit
// 5 → 4 → 3 → 2 → 1 → null
// \U0001f4ca Visual Snapshot of a Single Reversal:
// Before:
// ini
// Copy
// Edit
// head = 3
// head.next = 4
// head.next.next = ?  // goal: make 4 → 3
// Action:
// java
// Copy
// Edit
// head.next.next = head; // 4 → 3
// head.next = null;      // 3 → null
// After:
// python-repl
// Copy
// Edit
// ... → 5 → 4 → 3 → null
// \U0001f9e0 Why head.next = null?
// To break the original forward link. If we skip this, the list becomes circular, like:

// Copy
// Edit
// 3 → 4 → 3 → 4 → 3 → ...
// ✅ Final Visual:
// text
// Copy
// Edit
// Input:  1 → 2 → 3 → 4 → 5 → null
//                      ↑
//        recursion unwinds from here

// After:  5 → 4 → 3 → 2 → 1 → null


// class Solution {
//     public ListNode reverseList(ListNode head) {
//     ListNode prev=null;
//     ListNode curr=head;
//     while(curr!=null){
//         ListNode  temp=curr.next;    //step1
//         curr.next=prev;              //step2
//          prev = curr;                //step3
//         curr=temp;                   //step4
//     }
//     return prev;
//     }
// }