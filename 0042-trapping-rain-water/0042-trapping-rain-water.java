class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftBar = height[left];
        int rightBar = height[right];
        int totalWater = 0;

        while (left < right) {
            if (leftBar < rightBar) {
                left++;
                if (height[left] > leftBar) {
                    leftBar = height[left];
                } else {
                    totalWater += leftBar - height[left];
                }
            } else {
                right--;
                if (height[right] > rightBar) {
                    rightBar = height[right];
                } else {
                    totalWater += rightBar - height[right];
                }
            }
        }

        return totalWater;
    }
}
