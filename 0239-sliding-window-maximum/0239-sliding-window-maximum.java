import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        
        Deque<Integer> deq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            if (!deq.isEmpty() && deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }

            // Maintain deque in decreasing order
            while (!deq.isEmpty() && nums[i] > nums[deq.peekLast()]) {
                deq.pollLast();
            }

            deq.offerLast(i);

            // Start adding results when we have the first full window
            if (i >= k - 1) {
                result.add(nums[deq.peekFirst()]);
            }
        }

        // Convert List<Integer> to int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
