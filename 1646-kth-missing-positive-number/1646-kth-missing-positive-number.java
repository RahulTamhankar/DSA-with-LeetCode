class Solution {
    public int findKthPositive(int[] arr, int k) {
        int current = 1;  // Start checking from 1
        int i = 0;        // Pointer for arr

        while (k > 0) {
            if (i < arr.length && arr[i] == current) {
                i++; // current number is in arr, skip it
            } else {
                k--; // current number is missing
                if (k == 0) return current;
            }
            current++;
        }

        return -1; // Just in case, though it should never hit
    }
}
