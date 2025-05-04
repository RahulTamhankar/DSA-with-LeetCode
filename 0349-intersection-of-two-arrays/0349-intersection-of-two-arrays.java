import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // Sort first array
        Arrays.sort(nums2); // Sort second array

        int i = 0, j = 0;
        Set<Integer> resultSet = new HashSet<>();

        // Two-pointer traversal
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resultSet.add(nums1[i]); // Add to set for uniqueness
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
//         Why This Works:
// Because both arrays are sorted, we don't need to backtrack or check previous elements.

// At each step:

// We’re either finding a match and moving both forward, or

// Skipping the smaller value to try to "catch up" with the larger one.

// This ensures we only pass through each array once → very efficient.

        // Convert set to array
        int[] result = new int[resultSet.size()];
        int k = 0;
        for (int num : resultSet) {
            result[k++] = num;
        }

        return result;
    }
}

// class Solution {
//   public int[] intersection(int[] nums1, int[] nums2) {
//     Set<Integer> set = new HashSet<>();
//     Set<Integer> resultSet = new HashSet<>();

//     for (int num : nums1) {
//       set.add(num);
//     }
//     for (int num : nums2) {
//       if (set.contains(num)) {
//         resultSet.add(num); 
//       }
//     }
//     int[] result = new int[resultSet.size()];
//     int i = 0;
//     for (int num : resultSet) {
//       result[i++] = num;
//     }

//     return result;
//   }
// }
