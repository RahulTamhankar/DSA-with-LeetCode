
//Issue
// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int sum=0;
//         for(int x:nums){
//             sum+=x;
//         }
//         if (sum < Math.abs(target) || (sum + target) % 2 != 0) {
//     return 0;
// }

//         int n=nums.length;
//         int subset=(sum+target)/2;
//         int[][] dp=new int[n+1][subset+1];

//         for(int i=0;i<=n;i++){
//             for(int j=0;j<=subset;j++){
//                 if(j==0){
//                     dp[i][j]=1;
//                 }else if(i==0){
//                     dp[i][j]=0;
//                 }else if(nums[i-1]<=j){
//                     dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
//                 }else{
//                     dp[i][j]=dp[i-1][j];
//                 }
//             }
//         }
//         return dp[n][subset];
//     }
// }
// For this testcase:
// nums = [1]
// target = 2
// Total sum = 1
// Subset sum = (sum + target)/2 = (1+2)/2 = 1.5 → not an integer → invalid
// But your code mistakenly skips the target > sum logic because it's using:
// if (((sum - target) % 2 == 1) || (target > sum))
// This logic is incorrect for negative targets or non-integer subset values.

class Solution { 
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        // If target is out of range or (sum+target) is not even, no solution
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }

        int subset = (sum + target) / 2;
        int n = nums.length;

        int[][] dp = new int[n + 1][subset + 1];

        // Base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= subset; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][subset];
    }
}
