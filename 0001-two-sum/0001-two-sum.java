class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int start = 0;
        int end;

        while (start < nums.length) {
            end = start + 1;
            while (end < nums.length) {
                if (nums[start] + nums[end] == target) {
                    result[0] = start;
                    result[1] = end;
                    return result;
                }
                end++;
            }
            start++;
        }

        return result; // Optional: throw new IllegalArgumentException("No solution");
    }
}
