class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Bottom-up DP
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            //i=10
            for (int j = 1; j <= i; j++) {
                //left how many are smaller than
                //i ->i-1 ->3
                int leftBST = dp[j - 1];
                //right? (4)
                //10-3 =>6
                //right->4->5,6,7,8,9,10
                //left->4->1,2,3
                int rightBST = dp[i - j];
                sum += leftBST * rightBST;
            }
            dp[i] = sum;
        }

        return dp[n];
    }
}
