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



















// \U0001f914 Why not just for (int num : frequencyMap)?
// Because frequencyMap is a Map<Integer, Integer>, not something you can iterate over directly in a for-each loop. Java doesn’t know what part of the map you want to loop over — the keys, the values, or the entries (key-value pairs).

// So instead, Java gives you three options:

// ✅ 1. Loop over keys:
// java
// Copy
// Edit
// for (Integer key : frequencyMap.keySet()) {
//     int value = frequencyMap.get(key);
// }
// keySet() gives you all the keys.

// You can then get the value using frequencyMap.get(key).

// ✅ 2. Loop over values:
// java
// Copy
// Edit
// for (Integer value : frequencyMap.values()) {
//     // just values, not keys
// }
// values() gives you just the values (not helpful if you also need keys).

// ✅ 3. Loop over entries (✅ best for top K frequent):
// java
// Copy
// Edit
// for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
//     Integer key = entry.getKey();
//     Integer value = entry.getValue();
// }
// entrySet() gives you both key and value at once.

// This is required when you need both — which is exactly what you're doing in the top K frequent elements problem.

