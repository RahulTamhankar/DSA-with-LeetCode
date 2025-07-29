class Solution {
    public int maximumLength(int[] nums) {
        int countEven=0,countOdd=0;

        for(int num:nums){
            if(num%2==0){
                countEven++;
            }else{
                countOdd++;
            }
        }

        int alternativeLen=1;
        int prevParity=nums[0]%2;


        for(int i=1;i<nums.length;i++){
            int currParity=nums[i]%2;
            if(currParity!=prevParity){
                alternativeLen++;
                prevParity=currParity;
            }
        }
        return Math.max(Math.max(countEven,countOdd),alternativeLen);
    }
}