import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Max-heap based on the absolute difference (and value to break ties)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (b[0] == a[0]) {
                    return b[1] - a[1]; // If differences are equal, larger number has lower priority
                }
                return b[0] - a[0]; // Max-heap on difference
            }
        );

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            maxHeap.offer(new int[] { diff, arr[i] });

            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the furthest element
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }

        // The final list should be sorted in ascending order
        Collections.sort(result);

        return result;
    }
}
