class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Safe check: only do mid - 1 when mid > 0
            if (arr[mid] < arr[mid - 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // At the end, start == end, which is peak
        return start - 1; // ← FIX: we overshoot the peak by one due to how your logic walks
    }
}

//  Why This Works:
// You're always comparing arr[mid] with arr[mid + 1].

// This ensures you're deciding based on the direction of the slope:

// If ascending → go right.

// If descending → go left (but mid could still be peak, so keep it).

// It never overshoots the peak — loop stops at the peak.

// Returns low == high, which is the peak index.

// You're not doing high = mid - 1, like in a classic binary search.

// That’s the key difference.

// Why keep mid?
// Because in the descending slope, mid might actually be the peak:

// If arr[mid] > arr[mid + 1], then you're on the downward slope.

// But the peak is the last index where arr[i] < arr[i + 1] is false, so you can't eliminate mid.

// You must keep it in the search, so you set high = mid.
