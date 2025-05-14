class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int candidate=0;
        for(int n : nums){
            if(count==0){
                candidate=n;
            }
            if(n==candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}

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
