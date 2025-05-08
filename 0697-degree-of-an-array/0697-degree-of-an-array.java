import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> num_counts = new HashMap<>();
        HashMap<Integer, Integer> first_seen = new HashMap<>();

        int degree = 0;
        int min_length = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            first_seen.putIfAbsent(nums[i], i);
            num_counts.put(nums[i], num_counts.getOrDefault(nums[i], 0) + 1);

            int count = num_counts.get(nums[i]);

            if (count > degree) {
                degree = count;
                min_length = i - first_seen.get(nums[i]) + 1;
            } else if (count == degree) {
                min_length = Math.min(min_length, i - first_seen.get(nums[i]) + 1);
            }
        }

        return min_length;
    }
}

// import java.util.HashMap;

// class Solution {
//     public int findShortestSubArray(int[] nums) {
//         // Map to count frequency of each number
//         HashMap<Integer, Integer> num_counts = new HashMap<>();
        
//         // Map to store the first index where each number appears
//         HashMap<Integer, Integer> first_seen = new HashMap<>();

//         // Degree of the array = max frequency of any element
//         int degree = 0;
        
//         // Length of the shortest subarray with the same degree
//         int min_length = Integer.MAX_VALUE;

//         for (int i = 0; i < nums.length; i++) {
//             // Record the first occurrence of the number
//             first_seen.putIfAbsent(nums[i], i);
            
//             // Increment the count of the number
//             num_counts.put(nums[i], num_counts.getOrDefault(nums[i], 0) + 1);

//             // Get the current count of the number
//             int count = num_counts.get(nums[i]);

//             // If this number sets a new degree, update degree and subarray length
//             if (count > degree) {
//                 degree = count;
//                 min_length = i - first_seen.get(nums[i]) + 1;
//             } 
//             // If this number matches the current degree, update min_length if needed
//             else if (count == degree) {
//                 min_length = Math.min(min_length, i - first_seen.get(nums[i]) + 1);
//             }
//         }

//         // Return the length of the shortest subarray with same degree as the full array
//         return min_length;
//     }
// }

