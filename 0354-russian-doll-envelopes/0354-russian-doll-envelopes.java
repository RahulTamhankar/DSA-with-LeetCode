// import java.util.*;

// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2) {
//             return 0;
//         }
        
//         // Sort envelopes by width
//         Arrays.sort(envelopes, (a, b) -> {
//             if (a[0] == b[0]) {
//                 return a[1] - b[1];
//             } else {
//                 return a[0] - b[0];
//             }
//         });
        
//         int n = envelopes.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         int max = 1;
        
//         // DP to find LIS on height with width increasing
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             max = Math.max(max, dp[i]);
//         }
        
//         return max;
//     }
// }


class Solution {
    public int binarySearch(int[] dp, int val){
        int lo=0,hi=dp.length-1,res=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(dp[mid]<val){
                res=mid;
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return res+1;
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] LIS=new int[envelopes.length+1];
        Arrays.fill(LIS,Integer.MAX_VALUE);
        LIS[0]=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<envelopes.length;i++){
            int val=envelopes[i][1];
            int insertIndex=binarySearch(LIS,val);
            ans=Math.max(ans,insertIndex);
            if(LIS[insertIndex]>=val){
                LIS[insertIndex]=val;
            }
        }
        return ans;
    }
}