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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}
// And the return list1 or return list2 at each level is how the function returns the head of the new list after setting up the .next pointers correctly.

// merge(1, 2)
// │
// ├── 1 < 2 → list1.next = merge(3, 2)
//     │
//     ├── merge(3, 2)
//     │   └── 2 < 3 → list2.next = merge(3, 4)
//     │       │
//     │       ├── merge(3, 4)
//     │       │   └── 3 < 4 → list1.next = merge(5, 4)
//     │       │       │
//     │       │       ├── merge(5, 4)
//     │       │       │   └── 4 < 5 → list2.next = merge(5, 6)
//     │       │       │       │
//     │       │       │       ├── merge(5, 6)
//     │       │       │       │   └── 5 < 6 → list1.next = merge(null, 6)
//     │       │       │       │       │
//     │       │       │       │       └── merge(null, 6) → return 6
//     │       │       │       │
//     │       │       │       └── returns: 5 → 6
//     │       │       │
//     │       │       └── returns: 4 → 5 → 6
//     │       │
//     │       └── returns: 3 → 4 → 5 → 6
//     │
//     └── returns: 2 → 3 → 4 → 5 → 6

// └── returns: 1 → 2 → 3 → 4 → 5 → 6








//--------------------------------------------
//2ptr
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode dummy = new ListNode();
//         ListNode cur = dummy;

//         while (list1 != null && list2 != null) {
//             if (list1.val > list2.val) {
//                 cur.next = list2;
//                 list2 = list2.next;
//             } else {
//                 cur.next = list1;
//                 list1 = list1.next;
//             }
//             cur = cur.next; //otherwise cur will be dummy only in 1st iteration for example
//         }

//         cur.next = (list1 != null) ? list1 : list2;

//         return dummy.next;        
//     }
// }


// Initial State
// text
// Copy
// Edit
// dummy: 0 → null  
// cur = dummy

// list1: 1 → 3 → 5  
// list2: 2 → 4 → 6
// 1st Iteration
// 1 < 2, so:

// cur.next = list1 (1)

// list1 = list1.next (3)

// cur = cur.next (moves to 1)

// text
// Copy
// Edit
// Merged: 0 → 1  
//          ↑ cur

// list1: 3 → 5  
// list2: 2 → 4 → 6
// 2nd Iteration
// 3 > 2, so:

// cur.next = list2 (2)

// list2 = list2.next (4)

// cur = cur.next (moves to 2)