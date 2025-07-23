class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        // Find min and max values within the unsorted subarray
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    minVal = Math.min(minVal, nums[i]);
                    maxVal = Math.max(maxVal, nums[i]);
                }
            } else if (i == n - 1) {
                if (nums[i] < nums[i - 1]) {
                    minVal = Math.min(minVal, nums[i]);
                    maxVal = Math.max(maxVal, nums[i]);
                }
            } else {
                if (nums[i] > nums[i + 1] || nums[i] < nums[i - 1]) {
                    minVal = Math.min(minVal, nums[i]);
                    maxVal = Math.max(maxVal, nums[i]);
                }
            }
        }

        // If minVal or maxVal haven't changed, it means the array is already sorted
        if (minVal == Integer.MAX_VALUE || maxVal == Integer.MIN_VALUE) {
            return 0; // Return 0 if the array is already sorted
        }

        // Find the correct positions for minVal and maxVal subtract and get ans
        int i = 0;

        //[1 2 3 6] and we want to find the position of 5 here, 1 2 3 are <5 but 6>5 hence 5 should be placed at [1 2 3 5 6]
        while (i < n && nums[i] <= minVal) {  // so in the end i will have the position of min element
            i++;
        }

        int j = n - 1;  
        // exampel i want to fi d the position of 4 in [1 2 3 5 6] and i start from right side
        // 4 is < 5,6 but 4!<3 so 4 must be at [1 2 3 4 5 6]
        
        while (j >= 0 && nums[j] >= maxVal) {
            j--;
        }

        // The length of the unsorted subarray is j - i + 1
        return j - i + 1;
    }
}