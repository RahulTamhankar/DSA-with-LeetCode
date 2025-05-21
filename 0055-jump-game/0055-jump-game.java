class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        boolean[] t = new boolean[n];
        // t[i] = true means you can reach index i

        t[0] = true; // Already at the starting index

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i && t[j]) {//here t[j] == true means you should be able to reach j also, 
                                               //then only you can plan to jump(j+nums[i])  from this jth index
                    t[i] = true;
                    break; // No need to check further once we know i is reachable
                }
            }
        }

        return t[n - 1]; // Can we reach the last index?
    }
}


//OPTIMAL O(n)

//OPTIMAL Solution (ACCEPTED)
// class Solution {
// public:
//     bool canJump(vector<int>& nums) {
//         int maxReachable = 0;
//         int n            = nums.size();
        
//         for(int i = 0; i<n; i++) {
//             if(i > maxReachable) {
//                 return false;
//             }
//             maxReachable = max(maxReachable, nums[i]+i);
//         }
        
//         return true;
//     }
// };