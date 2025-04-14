class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int max=0;
        int[] dp=new int[prices.length];
        dp[0]=prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i]=Math.min(prices[i],dp[i-1]);
            max=Math.max(max,prices[i]-dp[i]);
        }
        return max;
    }
}