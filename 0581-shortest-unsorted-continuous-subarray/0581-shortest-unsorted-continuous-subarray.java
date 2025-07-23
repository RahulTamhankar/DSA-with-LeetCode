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

        // Find the correct positions for minVal and maxVal
        int i = 0;
        while (i < n && nums[i] <= minVal) {
            i++;
        }

        int j = n - 1;
        while (j >= 0 && nums[j] >= maxVal) {
            j--;
        }

        // The length of the unsorted subarray is j - i + 1
        return j - i + 1;
    }
}