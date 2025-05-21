class Solution {
    public int change(int amount, int[] coins) {
        int c=coins.length;
        int a=amount;
        int[][] dp=new int[c+1][a+1];

        for(int i=0;i<=c;i++){
            for(int j=0;j<=a;j++){
                if(j==0){
                    dp[i][j]=1;
                }else if(i==0){
                    dp[i][j]=0;
                }else if(coins[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[c][a];
    }
}
