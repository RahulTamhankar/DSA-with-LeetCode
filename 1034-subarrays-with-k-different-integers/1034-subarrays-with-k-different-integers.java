import java.util.HashMap;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        int i = 0, j = 0;
        int i_bada = 0;
        int result = 0;

        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            // Shrink window until we have at most k distinct integers
            while (mp.size() > k) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
                i_bada = i;
            }

            // Skip duplicates at the start of the window
            while (mp.containsKey(nums[i]) && mp.get(nums[i]) > 1) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                i++;
            }

            // Count subarrays with exactly k distinct
            if (mp.size() == k) {
                result += i - i_bada + 1;
            }

            j++;
        }

        return result;
    }
}
