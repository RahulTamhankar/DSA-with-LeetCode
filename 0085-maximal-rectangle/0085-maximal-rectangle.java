//Approach-1 (using NSL and NSR to find MAH (Maximum Area in Histogram)
//T.C : O(row*(col+col)) ~= O(row*col)
//S.C : O(col)
class Solution {
    public int[] NSR(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int pseudo_index = n;
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (st.empty()) {
                right[i] = pseudo_index;
            } else {
                while (!st.empty() && heights[st.peek()] >= heights[i])
                    st.pop();
                if (st.empty())
                    right[i] = pseudo_index;
                else
                    right[i] = st.peek();
            }
            st.push(i);
        }
        return right;
    }

    public int[] NSL(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int pseudo_index = -1;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (st.empty()) {
                left[i] = pseudo_index;
            } else {
                while (!st.empty() && heights[st.peek()] >= heights[i])
                    st.pop();
                if (st.empty())
                    left[i] = pseudo_index;
                else
                    left[i] = st.peek();
            }
            st.push(i);
        }
        return left;
    }

    public int MAH(int[] heights) {
        int n = heights.length;
        int[] right = NSR(heights);
        int[] left = NSL(heights);
        int[] width = new int[n];
        for (int i = 0; i < n; i++)
            width[i] = right[i] - left[i] - 1;
        int max_area = 0;

        for (int i = 0; i < n; i++) {
            int a = width[i] * heights[i];
            if (max_area < a)
                max_area = a;
        }
        return max_area;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        for (int i = 0; i < m; i++) {
            height[i] = (matrix[0][i] == '1') ? 1 : 0;
        }
        int maxA = MAH(height);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0')
                    height[j] = 0;
                else
                    height[j] += 1;
            }
            maxA = Math.max(maxA, MAH(height));
        }
        return maxA;
    }
}


