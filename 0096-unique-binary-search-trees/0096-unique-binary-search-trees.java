class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Bottom-up DP
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                int leftBST = dp[j - 1];
                int rightBST = dp[i - j];
                sum += leftBST * rightBST;
            }
            dp[i] = sum;
        }

        return dp[n];
    }
}
