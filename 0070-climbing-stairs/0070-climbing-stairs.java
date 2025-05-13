class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
// // We initialize dp[0] = 1 because it represents the one way to do nothing — i.e., you’re already at the bottom, and taking zero steps is still considered one valid path.
// \U0001f9e0 Think of It This Way:
// You’re trying to build up the solution from the bottom using dynamic programming:

// java
// Copy
// Edit
// dp[i] = dp[i - 1] + dp[i - 2];
// This means:

// To reach step i, you could’ve come from step i-1 or step i-2.

// So for this to work, you need base cases that won’t break the recurrence.


// i   dp[i] = dp[i-1] + dp[i-2]
// ------------------------------
// 0   1       (base case)
// 1   1       (base case)
// 2   2       = 1 + 1
// 3   3       = 2 + 1
// 4   5       = 3 + 2
// 5   8       = 5 + 3




// Real-World Analogy
// You're on the ground floor (step 0) and want to get to the n-th floor. At each step, you choose:

// To take 1 step up

// Or to take 2 steps up

// Your total number of paths depends on:

// How many ways you could have arrived from step n-1

// How many ways from step n-2

// That's exactly what dp[i] = dp[i-1] + dp[i-2] is doing.

