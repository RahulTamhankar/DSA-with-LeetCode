// //Approach-1
// //T.C : O(2^n)
// //S.C :  O(2^n*length of each subset) to store each subset
// //       The recursion stack space complexity is O(N) , the maximum depth of the recursion is N, where N is the length of the input array.
// public class Solution {
//     private List<List<Integer>> result = new ArrayList<>();

//     public List<List<Integer>> subsets(int[] nums) {
//         List<Integer> temp = new ArrayList<>();
//         solve(nums, 0, temp);
//         return result;
//     }

//     private void solve(int[] nums, int idx, List<Integer> temp) {
//         if (idx >= nums.length) {
//             result.add(new ArrayList<>(temp));
//             return;
//         }

//         temp.add(nums[idx]);
//         solve(nums, idx + 1, temp);
//         temp.remove(temp.size() - 1);
//         solve(nums, idx + 1, temp);
//     }
// }
//-------------------------

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsetCount = 1 << n; // 2^n subsets
        List<List<Integer>> ans = new ArrayList<>();

        for (int num = 0; num < subsetCount; num++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) { //check if the ith bit is set or not set. If nums&(1<<i) is a non-zero number then its set otherwise its not set
                    list.add(nums[i]); // I will pick up ith index number from the array
                }
            }
            ans.add(list);
        }

        return ans;
    }
}
//  Auxiliary (Extra) Space Complexity:
// If you ignore the output list ans, then yes — the extra space used is O(n) at most (for the temporary list created in each iteration). better than recursive in space

// ▶️ Total Space Complexity (including output):
// O(n × 2ⁿ) — because you're storing all subsets in memory.




// {1,2,3}
// | Decimal | Binary (3 bits) | Subset      |
// | ------- | --------------- | ----------- |
// | 0       | `000`           | `[]`        |
// | 1       | `001`           | `[1]`       |
// | 2       | `010`           | `[2]`       |
// | 3       | `011`           | `[1, 2]`    |
// | 4       | `100`           | `[3]`       |
// | 5       | `101`           | `[1, 3]`    |
// | 6       | `110`           | `[2, 3]`    |
// | 7       | `111`           | `[1, 2, 3]` |
