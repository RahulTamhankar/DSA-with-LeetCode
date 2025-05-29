// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Set<Integer> set = new HashSet<>();
        
//         // Add all elements to the set
//         for (int num : nums) {
//             set.add(num);
//         }
        
//         int ans = 0;
        
//         for (int num : nums) {
//             // Start sequence only if previous number is not in the set
//             //check if previous_element is in set
//             if (!set.contains(num - 1)) {
//                 int current = num;
//                 int count = 1;
//                 //start a chain from current element since previous is not in set
//                 while (set.contains(current + 1)) {
//                     current++;
//                     count++;
//                 }
                
//                 ans = Math.max(ans, count);
//             }
//         }
        
//         return ans;
//     }
// }

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        // Add all unique numbers to set
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) { // <-- important: iterate over set, not array
            // only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

