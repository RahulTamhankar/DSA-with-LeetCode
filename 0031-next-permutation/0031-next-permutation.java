import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int gola_index = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                gola_index = i - 1;
                break;
            }
        }

        // Step 2: If such an element exists, find the next larger element to the right
        if (gola_index != -1) {
            int swap_index = gola_index;
            for (int j = n - 1; j > gola_index; j--) {
                if (nums[j] > nums[gola_index]) {
                    swap_index = j;
                    break;
                }
            }
            // Swap gola_index and swap_index
            swap(nums, gola_index, swap_index);
        }

        // Step 3: Reverse the part after gola_index
        reverse(nums, gola_index + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
