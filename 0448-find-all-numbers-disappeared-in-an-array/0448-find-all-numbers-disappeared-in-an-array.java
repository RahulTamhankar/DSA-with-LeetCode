class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            int index=Math.abs(nums[i])-1;
            nums[index]=-Math.abs(nums[index]);
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}


// Why -1 needed in int index = Math.abs(nums[i]) - 1 ?
// The array has 0-based indexing, but the values in nums are 1-based.
// Say nums = [4,3,2,7,8,2,3,1]

// The values go from 1 to n = 8

// But array indices go from 0 to 7

// If nums[i] = 4, that means number 4 exists in the array.
// To mark it as visited, we need to make nums[3] (i.e., index 4-1) negative.