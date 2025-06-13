class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap based on distance from origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest point
            }
        }

        // Prepare the result array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
