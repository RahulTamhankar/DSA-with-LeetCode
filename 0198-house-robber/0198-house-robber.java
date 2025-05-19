//Rec +Memo=TopDown
//Bottom Up

//Why DP ? Since robber has many choices,say he can got to house with 1 or not go... ||ly can got to 3 or not go
//1)We have options to chose
//2)Maximum or optimal is asked
//3)Overlapping subproblems eg. (3,1) (2,3,1)->(3,1)


//Approach-1 (Recur + Memo)
// class Solution {
// public:
//     int t[101];
//     int solve(vector<int>& nums, int i, int& n) {
//         if(i >= n)
//             return 0;
        
//         if(t[i] != -1)
//             return t[i];
        
//         int take = nums[i] + solve(nums, i+2, n); //steals ith house and moves to i+2 (because we can't steal adjacent)
//         int skip = solve(nums, i+1, n); //skips this house, now we can move to adjacent next house
        
//         return t[i]=max(take, skip);
//     }
    
//     int rob(vector<int>& nums) {
//         int n = nums.size();
//         memset(t, -1, sizeof(t));
//         return solve(nums, 0, n);
//     }
// };

            /*
                SKIP  : If we skip this house,  then we have money till previous house  =  t[i-1]
                STEAL : If we steal this house, then we can't take prev profit, we can take till (i-2)th house profit = t[i-2]
            */



class Solution {
    public int rob(int[] nums) {
        // Bottom-Up DP (Tabulation)
        // Time: O(n)
        // Space: O(n)

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }
}


// Even more optimed to even remove dp in o(1)

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1) return nums[0];
//         if (n == 2) return Math.max(nums[0], nums[1]);

//         int prev2 = nums[0]; // dp[i - 2]
//         int prev1 = Math.max(nums[0], nums[1]); // dp[i - 1]

//         for (int i = 2; i < n; i++) {
//             int current = Math.max(nums[i] + prev2, prev1);
//             prev2 = prev1;
//             prev1 = current;
//         }

//         return prev1;
//     }
// }
// Explanation:
// prev2 holds the value for dp[i - 2]

// prev1 holds the value for dp[i - 1]

// current computes dp[i] using only these two