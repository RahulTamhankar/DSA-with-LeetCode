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
//  Time = O(m + n)

// \U0001f9ee Space Complexity: O(1)
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

//Solu 2
//   ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//     int lenA = getListLength(headA);
//     int lenB = getListLength(headB);

//     while (lenA > lenB) {
//       lenA--;
//       headA = headA.next;
//     }

//     while (lenB > lenA) {
//       lenB--;
//       headB = headB.next;
//     }

//     // Now both heads are at same distance from intersection
//     // Start moving them both until they meet
//     while(headA != headB) {
//       headA = headA.next;
//       headB = headB.next;
//     }

//     return headA;
//   }


//THIS WONT WORK
//  //2ptr
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         // ListNode lista=headA;
//         // ListNode listb=headB;

//        while (headA != headB) {
//     headA = (headA != null) ? headA.next : headB;
//     headB = (headB != null) ? headB.next : headA;
// }
// return headB;

//     }
// }


// Great question — you're asking why we use lista and listb instead of just using headA and headB directly.

// Let’s break it down:

// \U0001f50d What this code does:
// This is a two-pointer solution to find the intersection node of two singly linked lists. The idea is to:

// Traverse both lists with two pointers (lista, listb).

// When a pointer reaches the end, redirect it to the head of the other list.

// If there is an intersection, the pointers will eventually meet at the intersection node. If not, both will be null at the end.

// \U0001f9e0 Why not just use headA and headB?
// Let’s consider what would happen if you used headA and headB as your pointers directly:

// ❌ If you did this:
// java
// Copy
// Edit
// while (headA != headB) {
//     headA = (headA != null) ? headA.next : originalHeadB;
//     headB = (headB != null) ? headB.next : originalHeadA;
// }
// You’d be modifying the input arguments directly. This is not a good practice in general — especially if:

// You're inside a method that expects the input headA and headB to remain unchanged after execution.

// Someone wants to reuse headA or headB after calling this method — they'd be pointing somewhere else (maybe null).

// ✅ Why use lista and listb instead?
// They are local pointers used for traversal.

// They preserve the original headA and headB, which might be needed later.

// It's a clearer and safer approach, especially in interviews or production code.

// \U0001f4cc Analogy:
// Imagine headA and headB are maps showing the start of two roads.

// lista and listb are cars driving on those roads.

// You don’t want to scribble on the map while driving — you use a car to traverse it.

// ✅ Final Thought:
// You're right that technically we could use headA and headB directly — the code would still work. But using lista and listb is better style, safer, and preserves input integrity.

//////////////NO INTERSC EXAMPLE

// Step-by-step Walkthrough
// Let’s define:

// A = [1 → 2 → 3 → 4]

// B = [5 → 6 → 7 → 8]

// Initialize:

// lista = headA (1)

// listb = headB (5)

// Step	lista	listb	Equal?
// 1	1	5	❌
// 2	2	6	❌
// 3	3	7	❌
// 4	4	8	❌
// 5	null → headB=5	null → headA=1	❌
// 6	5	1	❌
// 7	6	2	❌
// 8	7	3	❌
// 9	8	4	❌
// 10	null	null	✅ Exit loop


// A travels till null then technically A becomes B
// B travels till null then technically B becomes A
