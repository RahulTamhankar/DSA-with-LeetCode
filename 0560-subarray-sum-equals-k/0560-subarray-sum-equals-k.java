//T.C : O(n)
//S.C : O(n)
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k))
                result += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}


// Storing (0,1) in the hashmap is bit confusing, instead we can just increase a check i.e. if(currSum == k) count++. The more readable code(JAVA) will look like this:

// public int subarraySum(int[] nums, int k) {
//         int currSum = 0, count = 0;
//         int n = nums.length;
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int i=0; i<n; i++) {
//             currSum += nums[i];

//             if(map.containsKey(currSum-k))
//                 count += map.get(currSum-k);

//             if(currSum == k)
//                 count++;

//             if(map.containsKey(currSum))
//                 map.put(currSum, map.get(currSum)+1);
//             else
//                 map.put(currSum, 1);
//         }

//         return count;
//     }