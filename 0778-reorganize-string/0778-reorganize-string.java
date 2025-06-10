// ************************************ JAVA ************************************
// //Approach-1 (Using Max-heap)
// class Solution {
//     public String reorganizeString(String S) {

//         Map<Character, Integer> map = new HashMap<>();
//         for (char c : S.toCharArray()) {
//             int count = map.getOrDefault(c, 0) + 1;
         
//             if (count > (S.length() + 1) / 2) 
//                 return "";
            
//             map.put(c, count);
//         }

        
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
//         for (char c : map.keySet()) {
//             pq.add(new int[] {map.get(c), c});
//         }
        
//         // Build the result.
//         StringBuilder sb = new StringBuilder();
//         while (pq.size() >= 2) {
//             int[] first  = pq.poll();
//             int[] second = pq.poll();
            
//             sb.append((char) first[1]);
//             sb.append((char) second[1]);
            
//             first[0]--;
//             second[0]--;
            
//             if(first[0] > 0)
//                 pq.add(first);
            
//             if(second[0] > 0)
//                 pq.add(second);

//         }
//         if(!pq.isEmpty()) {
//             int[] first  = pq.poll();
            
//             sb.append((char) first[1]);
//         }
        
//         return sb.toString();
//     }
// }


//Approach-2 (Using odd/even placement)
//TC- O(N)
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        
        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Find character with maximum frequency
        int maxFreq = 0;
        char charMaxFreq = 0;
        for (char ch : s.toCharArray()) {
            if (count[ch - 'a'] > maxFreq) {
                maxFreq = count[ch - 'a'];
                charMaxFreq = ch;
            }
        }

        // If max frequency exceeds limit, impossible to reorganize
        if (maxFreq > (n + 1) / 2) {
            return "";
        }

        char[] result = new char[n];
        int i = 0;

        // Place max frequency character at even indices first
        while (count[charMaxFreq - 'a'] > 0) {
            result[i] = charMaxFreq;
            count[charMaxFreq - 'a']--;
            i += 2;
        }

        // Place remaining characters
        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (count[ch - 'a'] > 0) {
                if (i >= n) {
                    i = 1; // Start placing at odd indices
                }
                result[i] = ch;
                count[ch - 'a']--;
                i += 2;
            }
        }

        return new String(result);
    }
}
