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
            fast = nums[fast];
        }

        return fast; // or return slow
    }
}
