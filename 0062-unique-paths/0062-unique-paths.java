class Solution {
    public int uniquePaths(int m, int n) {
        // Initialize all cells with 1
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1);  // Fill each row with 1s
        }

        // Start from cell (1,1) since first row and column are already 1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
