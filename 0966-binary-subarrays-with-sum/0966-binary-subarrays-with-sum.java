// // Approach-1 (Simple prefix sum) - These kinds of questions can always be solved using a Map and cumulative sum technique
// // T.C: O(n)
// // S.C: O(n)
// class Solution1 {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int n = nums.length;
        
//         // HashMap to store cumulative sums and their frequencies
//         HashMap<Integer, Integer> mp = new HashMap<>();
        
//         int count = 0;
//         int currSum = 0;
//         mp.put(0, 1);
//         for (int num : nums) {
//             currSum += num;

//             // If there is a previous sum such that (current sum - previous sum) equals goal, increment count by the frequency of that previous sum
//             if (mp.containsKey(currSum - goal)) {
//                 count += mp.get(currSum - goal);
//             }
            
//             // Increment the frequency of current sum in the map
//             mp.put(currSum, mp.getOrDefault(currSum, 0) + 1);
//         }
        
//         return count;
//     }
// }


// Approach-2 (Using Sliding Window)
// This could be a straightforward sliding window but the presence of 0 makes it a little tricky.
// Example: [0, 0, 0, 1, 1] -> Total subarrays having goal = 2 will be 4 - {0, 0, 0, 1, 1}, {0, 0, 1, 1}, {0, 1, 1}, {1, 1}
// So, simply find the count of zeros before the sum has reached the goal i.e., 3 (Now, 1+1 = goal, so total subarrays = prefix_zeros + 1 = 3 + 1 = 4)
// T.C: O(n)
// S.C: O(1)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixZeros=0;
        int windowSum=0;
        int count=0;

        int i=0,j=0;

        while(j<nums.length){
            windowSum+=nums[j];

            while(i<j &&(nums[i]==0 || windowSum>goal)){
                if(nums[i]==1){
                    prefixZeros=0;
                }else{
                    prefixZeros+=1;
                }
                windowSum-=nums[i];
                i++;
            }

            if(windowSum==goal){
                count+=1+prefixZeros;
            }
            j++;
        }
        return count;
    }
}