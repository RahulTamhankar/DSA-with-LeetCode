public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];

        // Push all elements except the last one (as in your original C++ code)
        for (int i = n - 2; i >= 0; i--) {
            stack.push(nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);
        }

        return result;
    }     
}



// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int n = nums.length;
//         int[] res = new int[n];
//         Stack<Integer> stack = new Stack<>();

//         // Initialize result with -1
//         Arrays.fill(res, -1);

//         // Loop from 2n - 1 to 0 to simulate circularity
//         for (int i = 2 * n - 1; i >= 0; i--) {
//             int index = i % n;
//             while (!stack.isEmpty() && nums[stack.peek()] <= nums[index]) {
//                 stack.pop();
//             }
//             if (i < n) {
//                 res[index] = stack.isEmpty() ? -1 : nums[stack.peek()];
//             }
//             stack.push(index);
//         }

//         return res;
//     }
// }
