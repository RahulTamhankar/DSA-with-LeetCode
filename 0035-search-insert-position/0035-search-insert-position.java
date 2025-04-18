class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid=0;
        int midValue=0;
        while(start<=end){
            mid=start+(end-start)/2;
            midValue=nums[mid];
            if(midValue<target){
                start=mid+1;
            }else if(midValue>target){
                end=mid-1;
            }else{
                return mid;
            }
        }
        return start;
    }
}

// Why return start?
// Let’s take an example:
// nums = [1, 3, 5, 6]
// target = 2
// 1st iteration:

// mid = 1, nums[1] = 3

// 3 > 2 → move left → end = 0

// 2nd iteration:

// start = 0, end = 0

// mid = 0, nums[0] = 1

// 1 < 2 → move right → start = 1

// Loop ends: start = 1, end = 0


// 2 doesn’t exist in the array.

// But the correct position to insert 2 is index 1, between 1 and 3.
