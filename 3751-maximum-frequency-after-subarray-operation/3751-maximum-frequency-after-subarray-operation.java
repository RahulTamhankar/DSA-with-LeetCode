// import java.util.*;

// class Solution {

//     // Helper method to calculate max gain for a specific target value
//     public int calculateMaxGain(List<Integer> nums, int targetValue, int k) {
//         int maxGain = 0;
//         int currentGain = 0;

//         for (int num : nums) {
//             if (num == k) currentGain--;
//             if (num == targetValue) currentGain++;
//             if (currentGain < 0) currentGain = 0;
//             maxGain = Math.max(maxGain, currentGain);
//         }

//         return maxGain;
//     }

//     public int maxFrequency(int[] nums, int k) {
//         Map<Integer, Integer> frequencyMap = new HashMap<>();
//         List<Integer> numList = new ArrayList<>();
//         for (int num : nums) {
//             frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//             numList.add(num);
//         }

//         int maxFrequency = 0;
//         for (int value : frequencyMap.keySet()) {
//             maxFrequency = Math.max(maxFrequency, calculateMaxGain(numList, value, k));
//         }

//         return frequencyMap.getOrDefault(k, 0) + maxFrequency;
//     }
// }


class Solution {
    public int maxFrequency(int[] nums, int k) {
        int kCount = 0;
        for (int num : nums) {
            if (num == k) {
                kCount++;
            }
        }
        int res = kCount;
        int sum = 0;
        for (int i = 1; i <= 50; i++) {
            if (i == k) {
                continue;
            }
            int count = 0;
            for (int num : nums) {
                if (num == k) {
                    count--;
                    if (count < 0) {
                        count = 0;
                    }
                }
                if (num == i) {
                    count++;
                }
                sum = Math.max(sum, kCount + count);
            }
        }
        return Math.max(res, sum);
    }
}
