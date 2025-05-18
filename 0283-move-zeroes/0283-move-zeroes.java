// class Solution {
//     public void moveZeroes(int[] nums) {
//         int i=0;
//         int j=0;
//         while(j<nums.length){
//             if(nums[j]!=0){
//                 int temp=nums[i];
//                 nums[i]=nums[j];
//                 nums[j]=temp;
//                 i++;
//             }
//                 j++;
        
//         }
//     }
// }


class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                start++;
            }
        }
    }
}
