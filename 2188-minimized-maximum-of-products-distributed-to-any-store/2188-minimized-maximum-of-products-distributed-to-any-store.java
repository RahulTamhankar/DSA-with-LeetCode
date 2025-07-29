class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        for (int q : quantities) {
            right = Math.max(right, q);
        }

        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (possibleToDistrib(mid, quantities, n)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean possibleToDistrib(int x, int[] quantities, int shops) {
        for (int q : quantities) {
            shops -= (q + x - 1) / x; // equivalent to ceil(q / x)
            if (shops < 0) {
                return false;
            }
        }
        return true;
    }
}
