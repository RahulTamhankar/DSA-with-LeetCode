class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int ans=0;

        for(int i=0;i<nums.length;i++){
            int first=nums[i];
            int start=i+1;
            int end=nums.length-1;

            while(start<end){
                int sum=first+nums[start]+nums[end];
                if(sum==target){
                    return target;
                }else if(Math.abs(sum-target)<diff){
                    diff=Math.abs(sum-target);
                    ans=sum;
                }

                if(sum<target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return ans;
    }
}