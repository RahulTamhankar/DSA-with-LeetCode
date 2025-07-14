import java.util.*;

class Solution {
    int n;
    int[][] dp;

    public int solve(int[][] events, int i, int k) {
        if (k <= 0 || i >= n)
            return 0;

        if (dp[i][k] != -1)
            return dp[i][k];

        int start = events[i][0];
        int end = events[i][1];
        int value = events[i][2];

        // Find next event we can attend using binary search
        int nextIndex = findNext(events, end);

        int take = value + solve(events, nextIndex, k - 1);
        int skip = solve(events, i + 1, k);

        return dp[i][k] = Math.max(take, skip);
    }

    // Helper function to find next event using binary search
    public int findNext(int[][] events, int currentEnd) {
        int low = 0, high = n - 1;
        int ans = n; // if not found, return n

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > currentEnd) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        n = events.length;
        dp = new int[n + 1][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(events, 0, k);
    }
}
