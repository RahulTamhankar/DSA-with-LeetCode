import java.util.*;

class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = x.length;

        // Step 1: Build map with max values for each key
        for (int i = 0; i < n; i++) {
            int key = x[i];
            int value = y[i];
            map.put(key, Math.max(map.getOrDefault(key, Integer.MIN_VALUE), value));
        }

        // Step 2: If there are fewer than 3 distinct keys, return -1
        if (map.size() < 3) {
            return -1;
        }

        // Step 3: Find top 3 maximum values
        int flv = Integer.MIN_VALUE;  // first largest value
        int slv = Integer.MIN_VALUE;  // second largest value
        int tlv = Integer.MIN_VALUE;  // third largest value

        for (int val : map.values()) {
            if (val > flv) {
                tlv = slv;
                slv = flv;
                flv = val;
            } else if (val > slv) {
                tlv = slv;
                slv = val;
            } else if (val > tlv) {
                tlv = val;
            }
        }

        return flv + slv + tlv;
    }
}
