class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        // Step 2: Merge overlapping intervals
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                // Overlapping intervals, merge them
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // No overlap, add new interval to result
                newInterval = interval;
                result.add(newInterval);
            }
        }

        // Step 3: Convert result list to 2D array
        return result.toArray(new int[result.size()][]);
    }
}



// /return result.toArray(new int[result.size()][]);
// This line converts the List<int[]> to a 2D array (int[][]), which is the required return type for the merge method.

// \U0001f50d Why is this needed?
// You're using a List<int[]> result to dynamically store merged intervals.

// But the method's return type is int[][], not List<int[]>.

// So you need to convert the list into an array before returning it.