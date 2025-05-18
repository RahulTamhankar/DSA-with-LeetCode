// class Solution {
//     public int majorityElement(int[] nums) {
//         int count=0;
//         int candidate=0;
//         for(int n : nums){
//             if(count==0){
//                 candidate=n;
//             }
//             if(n==candidate){
//                 count++;
//             }else{
//                 count--;
//             }
//         }
//         return candidate;
//     }
// }

//Boyer-Moore Majority Vote Algorithm.
// Input: [2,2,1,1,1,2,2]
// Output: 2
// | n | candidate | count |
// | - | --------- | ----- |
// | 2 | 2         | 1     |
// | 2 | 2         | 2     |
// | 1 | 2         | 1     |
// | 1 | 2         | 0     |
// | 1 | 1         | 1     |
// | 2 | 1         | 0     |
// | 2 | 2         | 1     |
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // Fixed typo from 'candiddate' and 'nus'
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i]; // pick a new candidate
                    count = 1;
                }
            }
        }

        return candidate;
    }
}
