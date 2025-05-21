class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            if(i<2) dp[i]=cost[i];
            else dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}

// Why dp[i] = cost[i] +.....?
// To reach step i, you must have come from either:

// Step i-1 (then you pay cost[i])

// Step i-2 (then you also pay cost[i])

// So:

// java
// Copy
// Edit
// dp[i] = cost[i] + min(dp[i-1], dp[i-2])
// You're taking the cheaper path to get to step i.


// Why return min(dp[n-1], dp[n-2]) and not just dp[n-1]?
// Because you can reach the top of the stairs from either:

// Step n-1

// Step n-2

// You don’t have to land exactly on n-1. The goal is to go beyond the last step, and from the last two steps, you can jump off.

// So:

// java
// Copy
// Edit
// return Math.min(dp[n-1], dp[n-2]);
// This gives you the minimum cost to climb past the last step.
