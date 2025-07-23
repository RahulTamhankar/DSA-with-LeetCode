class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int start=0;
        int end=0;
        Set<Integer> set=new HashSet<>();
        int sum=0;
        int ans=0;

        while(end<nums.length){
            while(start<end && set.contains(nums[end])){
                set.remove(nums[start]);
                sum-=nums[start];
                start++;
            }

            set.add(nums[end]);
            sum+=nums[end];
            end++;

            ans=Math.max(ans,sum);
        }
        return ans;
    }
}