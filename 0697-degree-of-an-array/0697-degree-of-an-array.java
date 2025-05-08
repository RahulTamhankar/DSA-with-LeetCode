import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> num_counts = new HashMap<>();
        HashMap<Integer, Integer> first_seen = new HashMap<>();

        int degree = 0;
        int min_length = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            first_seen.putIfAbsent(nums[i], i);
            num_counts.put(nums[i], num_counts.getOrDefault(nums[i], 0) + 1);

            int count = num_counts.get(nums[i]);

            if (count > degree) {
                degree = count;
                min_length = i - first_seen.get(nums[i]) + 1;
            } else if (count == degree) {
                min_length = Math.min(min_length, i - first_seen.get(nums[i]) + 1);
            }
        }

        return min_length;
    }
}
