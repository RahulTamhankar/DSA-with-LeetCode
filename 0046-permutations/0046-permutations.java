//Approach 1 (Swap-based Backtracking)
//  Time Complexity: O(n!)
// There are n! total permutations.

// For each permutation, copying the array to a list takes O(n).

// So technically: O(n * n!)
// Space Complexity: O(n) (excluding result)
// Recursion stack: up to O(n) depth due to n recursive calls.
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        solve(0, nums);
        return result;
    }

    private void solve(int idx, int[] nums) {
        if (idx == n) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            result.add(perm);
            return;
        }

        //idx = which nos to swap, initally when idx =0 we explore {1,2,3}
        for (int i = idx; i < n; i++) {  // If we start i from 0 then swapping will be done for same combination again EX. when idx=2 {2,1,3} if we start i from 0 the it will become {1,2,3} again which was already explored when idx was 1 !. Hence start i from idx everytime
            swap(nums, i, idx);
            solve(idx + 1, nums);
            swap(nums, i, idx); // backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//Approach 2 (Backtracking using HashSet to track used elements)
//  Time Complexity: O(n * n!)
// Similar to Approach 1: n! permutations.

// For each recursive step, looping through n elements, making this O(n * n!) in total.

// ✅ Space Complexity: O(n) (excluding result)
// Recursion stack: up to O(n) calls.

// Temp list: holds n elements max.

// HashSet (used): holds up to n elements.

// So: O(n) auxiliary space.

// class Solution {
//     List<List<Integer>> result = new ArrayList<>();
//     Set<Integer> used = new HashSet<>();
//     int n;

//     public List<List<Integer>> permute(int[] nums) {
//         n = nums.length;
//         List<Integer> temp = new ArrayList<>();
//         solve(temp, nums);
//         return result;
//     }

//     private void solve(List<Integer> temp, int[] nums) {
//         if (temp.size() == n) {
//             result.add(new ArrayList<>(temp));
//             return;
//         }

//         for (int i = 0; i < n; i++) {
//             if (!used.contains(nums[i])) {
//                 temp.add(nums[i]);
//                 used.add(nums[i]);

//                 solve(temp, nums);

//                 used.remove(nums[i]); // backtrack
//                 temp.remove(temp.size() - 1);
//             }
//         }
//     }
// }
