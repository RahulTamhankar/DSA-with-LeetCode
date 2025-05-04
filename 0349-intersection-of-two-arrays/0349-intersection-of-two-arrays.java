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

        // Convert set to array
        int[] result = new int[resultSet.size()];
        int k = 0;
        for (int num : resultSet) {
            result[k++] = num;
        }

        return result;
    }
}
