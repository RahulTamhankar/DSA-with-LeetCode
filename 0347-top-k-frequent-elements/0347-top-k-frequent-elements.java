// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         int[] res=new int[nums.length+1];
//         int currNum=nums[0];
//         int count=0;
//         int j=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==currNum){
//                 count++;
//             }
//             else{
//                 currNum=nums[i];
//             }
//             if(count>=k){
//                 res[j]=nums[i];
//                 count=0;
//                 j++;
//             }
//         }
//         return res;
//     }
// }

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-heap to keep top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue() // Min-heap based on frequency
        );

        // Step 3: Maintain only top k frequent elements in the heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract results from heap to array
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }
}
