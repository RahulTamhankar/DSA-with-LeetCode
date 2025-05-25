class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=1;i<=n;i++){
            ans=ans^i;
        }
        for(int i=0;i<n;i++){
            ans=ans^nums[i];
        }
        return ans;
    }
}

//1st for-ans = 0 ^ 1 ^ 2 ^ 3 ^ 4
