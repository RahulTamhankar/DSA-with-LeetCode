class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;

        for(int x:nums){
            sum+=x;
        }

        if(sum%2!=0){
            return false;
        }else{
            return isSubsetSum(nums,n,sum/2);
        }
    }

    private static boolean isSubsetSum(int[] arr,int n,int sum){
        boolean[][] dp=new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    dp[i][j]=true;
                }else if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}