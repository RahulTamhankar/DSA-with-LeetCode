class Solution {

    private int cs(int[] nums,int target,int[] dp){
        if(target<0) return 0;
        
        if(dp[target]!=-1) return dp[target];

        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=cs(nums,target-nums[i],dp);
        }
        dp[target]=count;
        return dp[target];
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        return cs(nums,target,dp);
    }
}