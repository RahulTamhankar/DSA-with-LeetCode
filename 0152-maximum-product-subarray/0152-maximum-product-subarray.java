// //DP
// class Solution {
//     public int maxProduct(int[] nums) {
//         int max=nums[0],min=nums[0],
//         res=nums[0]; //cant initialize it to 0 coz if there is a single element in arr nums say [-1] then max product is even less than 0, so its not good to initalize to 0

//         for(int i=1;i<nums.length;i++){
//             int temp=max;

//             //since 0 ruins our max streak, if any num is 0 then just continue
             
//             max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
//             min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);        
            
//             if(max>res){
//                 res=max;
//             }
//             }
//         return res;
//     }
// }

import java.util.List;

class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;  //cant initialize it to 0 coz if there is a single element in arr nums say [-1] then max product is even less than 0, so its not good to initalize to 0

        int curMin = 1, curMax = 1;

        for (int n : nums) {
            if (n == 0) { //             //since 0 ruins our max streak, if any num is 0 then just continue

                curMin = 1;
                curMax = 1;
                res = Math.max(res, 0); // Handle zero explicitly
                continue;
            }

            int tmp = curMax * n;
            curMax = Math.max(n * curMax, Math.max(n * curMin, n));
            curMin = Math.min(tmp, Math.min(n * curMin, n));
            res = Math.max(res, curMax);
        }

        return res;
    }
}




// //BS
// class Solution {
//     public int maxProduct(int[] nums) {
        
//         int n = nums.length;
//         int l=1,r=1;
//         int ans=nums[0];
        
//         for(int i=0;i<n;i++){
            
// 			//if any of l or r become 0 then update it to 1
//             l = l==0 ? 1 : l;
//             r = r==0 ? 1 : r;
            
//             l *= nums[i];   //prefix product
//             r *= nums[n-1-i];    //suffix product
            
//             ans = Math.max(ans,Math.max(l,r));
            
//         }
        
//         return ans;

//     }
// }