//T.C : O(n^2)
//S.C : O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int n1=nums[i];
            int target=-n1;
            twoSum(nums, i + 1, result, target); // 2 sum iscalculated from i+1 to n-1, n-1 is done inside twoSum method
        }

        return result;
    }


    private void twoSum(int[] nums, int k, List<List<Integer>> result, int target) {
        int i = k, j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {

                //first we will remove duplicates from either end (i,j)
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }

                result.add(Arrays.asList(-target, nums[i], nums[j]));


                i++;
                j--;
            }
        }
    }
}