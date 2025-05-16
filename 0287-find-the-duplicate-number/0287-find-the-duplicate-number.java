//T.C : O(n) Using "Hare & tortoise technique"
//S.C : O(1)
class Solution { 
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        // Move pointers to find the intersection point inside the cycle
        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Reset one pointer to start and move both at same pace
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];  //this fast inside nums[] is the one we got in previous while ie when we detected cycle
            // p=x where p is distance from start till entry point of node and x is where the fast ptr is at 
        }

        return fast; // or return slow
    }
}


//If you dont use         int slow = nums[0], fast = nums[0];
//  then you get TLE ie if you do slow=0,fast=0 
//  Or use do while To fix this, you should initialize both slow and fast to 0 but move them only inside the loop—specifically use a do-while loop to ensure at least one move before the comparison, like in the original version.

//  class Solution { 
//     public int findDuplicate(int[] nums) {
//         int slow = 0, fast = 0;

//         // Phase 1: Detect intersection point inside the cycle
//         do {
//             slow = nums[slow];
//             fast = nums[nums[fast]];
//         } while (slow != fast);

//         // Phase 2: Find entrance to the cycle (duplicate number)
//         slow = 0;

//         while (slow != fast) {
//             slow = nums[slow];
//             fast = nums[fast];
//         }

//         return slow; // or fast
//     }
// }
// Why this works:
// Using do-while ensures both pointers move at least once before the check (slow != fast).

// Resetting slow to 0 then moving both one step at a time guarantees they meet at the duplicate entry point.