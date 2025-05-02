class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        int leftSum=0;
        for(int i=0;i<nums.length;i++){
            if(leftSum==totalSum-leftSum-nums[i]){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}

// For nums = [1, 7, 3, 6, 5, 6], total sum is 28.

// At index i = 3, nums[3] = 6, and:

// leftSum = 1 + 7 + 3 = 11

// Right sum = 5 + 6 = 11

// Now plug into the condition:

// java
// Copy
// Edit
// if (11 == 28 - 11 - 6) // -> if (11 == 11)
// ✅ It's true, so 3 is the pivot index.