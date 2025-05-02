public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;         // Pointer at end of nums1's valid part
        int j = n - 1;         // Pointer at end of nums2
        int k = m + n - 1;     // Pointer at end of nums1's full length

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has elements, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
// Example:
// java
// Copy
// Edit
// nums1 = [0], m = 0
// nums2 = [1], n = 1
// Initial pointers:

// i = m - 1 = -1 → No valid elements in nums1

// j = n - 1 = 0 → pointing at 1

// k = m + n - 1 = 0 → last index of nums1

// \U0001f501 Merge Loop:
// Main loop:

// java
// Copy
// Edit
// while (i >= 0 && j >= 0) { ... }
// → This doesn't run because i = -1

// So we go straight to:

// java
// Copy
// Edit
// while (j >= 0) {
//     nums1[k--] = nums2[j--];
// }
// j = 0, k = 0

// nums1[0] = nums2[0] = 1

// j-- → -1, k-- → -1

// \U0001f449 Final nums1 = [1]

// ✅ Why This Matters:
// This step ensures that if nums2 has any values left, they're correctly placed into nums1.

// It handles edge cases like:

// nums1 starts empty (m = 0)

// All nums2 values are smaller than nums1 values and should come first

