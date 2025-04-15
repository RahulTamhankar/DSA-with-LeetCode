class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0; // Pointer for where the next non-zero should go
        int j = 0; // Pointer for traversing the array

        while (j < nums.length) {
            if (nums[j] != 0) {
                // Swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }
}
