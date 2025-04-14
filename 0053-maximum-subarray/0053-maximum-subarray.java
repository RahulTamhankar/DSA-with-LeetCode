class Solution {
    public int maxSubArray(int[] nums) {
    //     return helper(nums,0,nums.length-1);
    // }

    // public int helper(int[] nums, int left,int right){

    //     if(left==right){
    //         return nums[left];
    //     }

    //     int mid=(left+right)/2;

    //     int leftSum=Integer.MIN_VALUE;
    //     int total=0;
    //     for (int i = mid; i >= left; i--) {
    //         total += nums[i];
    //         leftSum = Math.max(leftSum, total);
    //     }

    //     int rightSum=Integer.MIN_VALUE;
    //     total=0;
    //     for(int i=mid+1;i<=right;i++){
    //         total+=nums[i];
    //         rightSum=Math.max(rightSum,total);
    //     }

    //     int maxLeftRight=Math.max(helper(nums,left,mid),helper(nums,mid+1,right));

    //     return Math.max(maxLeftRight,leftSum+rightSum);

    //Kadane
    // int currSum=nums[0];
    // int maxSum=nums[0];
    // for(int i=1;i<nums.length;i++){
    //     if(currSum<0 && nums[i]>currSum){
    //         currSum=nums[i];
    //     }else{
    //         currSum+=nums[i];
    //     }
    //     maxSum=Math.max(currSum,maxSum);
    // }
    // return maxSum;

    //DP
    int[] dp=new int[nums.length];
    int max=nums[0];
    dp[0]=nums[0];
    for(int i=1;i<nums.length;i++){
      dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
      if(dp[i]>max){
        max=dp[i];
      }  
    }
    return max;

    }
}