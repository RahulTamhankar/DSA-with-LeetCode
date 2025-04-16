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
    public ListNode reverse(ListNode head){
         ListNode prev=null;
         ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }


    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode rev= reverse(slow.next);
        slow.next=null;
        while(rev!=null){
            if(head.val!=rev.val){
                return false;
            }
            head=head.next;
            rev=rev.next;
        }
        return true;
    }
}

//List
// while (left < right) {
//     if (!list.get(left).equals(list.get(right))) {
//         return false; // As soon as there's a mismatch, it's not a palindrome
//     }
//     left++;
//     right--;
// }
// return true; // All matched, so it's a palindrome

//Recursion
//  What You're Trying to Do:
// You want to check if a singly linked list is a palindrome — meaning it reads the same forwards and backwards.

// Since you can't go backward in a singly linked list, you use recursion to reach the end, and then compare values while coming back (like unwinding the stack).

// \U0001f501 What the Code Does:
// java
// Copy
// Edit
// ListNode curr;
// You use a global pointer curr to move from start to end, like forward reading.

// java
// Copy
// Edit
// curr = head;
// return solve(head);
// You initialize curr at the head and start the recursive solve() function.

// \U0001f50d Inside solve():
// java
// Copy
// Edit
// if (head == null) return true;
// When you reach the end (null), you return true. This is your base case.

// java
// Copy
// Edit
// boolean ans = solve(head.next) && head.val == curr.val;
// Now this is the core logic:

// solve(head.next) goes all the way to the end first.

// Then, as the call stack unwinds, it compares:

// head.val → values from the end going backward

// curr.val → values from the start going forward

// So you’re matching front and back elements one by one, like this:

// bash
// Copy
// Edit
// head → 1 → 2 → 2 → 1
// curr → 1 ↑       ↑ head
// Then:

// Compare: 1 == 1 ✔️

// Move curr to next

// Compare: 2 == 2 ✔️

// and so on...

// java
// Copy
// Edit
// curr = curr.next;
// You move curr forward each time a comparison happens.

// java
// Copy
// Edit
// return ans;
// If all pairs match, return true; otherwise, false.

// ✅ Why It Works:
// Recursion goes to the end of the list (last node).

// Then, while returning back through the stack, it checks each node against a node from the start (using curr).

// This way, you simulate two pointers: one from the front, one from the back.

// \U0001f4a1 Simple Analogy:
// Imagine reading a word backward using a mirror. Recursion gives you that mirror image from the end, and you compare each letter to the original.

// Let me know if you want a walkthrough with an actual example like [1, 2, 2, 1], or want to discuss the tradeoffs (e.g., recursion depth)!






