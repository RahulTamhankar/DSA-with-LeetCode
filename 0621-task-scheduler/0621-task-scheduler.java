//Approach (Heap + Greedy)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int leastInterval(char[] tasks, int p) {
        // Build frequency map
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        
        // Max heap to store frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        int time = 0;
        // Process tasks until the heap is empty
        while (!pq.isEmpty()) {
            int cycle = p + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            // Execute tasks in each cycle
            while (cycle-- > 0 && !pq.isEmpty()) {
                int currentFreq = pq.poll();
                if (currentFreq > 1) {
                    store.add(currentFreq - 1);
                }
                taskCount++;
            }
            // Restore updated frequencies to the heap
            store.forEach(pq::offer);
            // Add time for the completed cycle
            time += (pq.isEmpty() ? taskCount : p + 1);
        }
        return time;
    }
}

// store.forEach(pq::offer);
// for (int val : store) {
//     pq.offer(val);
// }

//--------------------------------------
// class Solution {
// public:
//     int leastInterval(vector<char>& tasks, int p) {
//         int n = tasks.size();
        
//         if(p == 0)
//             return n;
        
//         /*
        
//         ["A","A","A","B","B","B"], k = 2
//         A-3
//         b-3
//         A _ _ A _ _ A
//         Number of chunks     = freq('A')-1 = 2
//         Number of idol spots = (Number of chunks)*(p) = 2*2 = 4
            
//         Now, we will try to fill these 4 idol spots
//         If at the end idol spots is 0, it means all idol spots were enough
//         to accomodate all other taks. So, out result will be tasks.size();
        
//         If, idol spots are not empty, it means that we need more spaces (equal to idol spots)
//         than the tasks.size() to accomodate all tasks.
//         So, result = tasks.size() + idol_spots
        
//         */
        
//         int counter[26] = {0};
//         for(char &ch : tasks) {
//             counter[ch-'A']++;
//         }
        
//         sort(begin(counter), end(counter));
        
//         int chunks      = counter[25]-1;
//         int idolSpots   = chunks*p;
        
//         for(int i = 24; i>=0 ; i--) {
//             idolSpots -= min(chunks, counter[i]);
//         }
        
//         if(idolSpots > 0)
//             return n + idolSpots;
        
//         return n;
//     }
// };