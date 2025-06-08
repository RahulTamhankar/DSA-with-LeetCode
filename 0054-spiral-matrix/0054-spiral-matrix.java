class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        int dir = 0; // 0→, 1↓, 2←, 3↑

        while (top <= bottom && left <= right) {
            if (dir == 0) { // left to right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) { // top to bottom
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) { // right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            } else if (dir == 3) { // bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4; // rotate direction
        }

        return result;
    }
}

// This line is used to rotate the direction of traversal in a cyclic manner through the four possible directions in the spiral pattern:
// | Current `dir` | `(dir + 1) % 4` | New `dir` | Movement              |
// | ------------- | --------------- | --------- | --------------------- |
// | 0             | (0 + 1) % 4 = 1 | 1         | Top to Bottom         |
// | 1             | (1 + 1) % 4 = 2 | 2         | Right to Left         |
// | 2             | (2 + 1) % 4 = 3 | 3         | Bottom to Top         |
// | 3             | (3 + 1) % 4 = 0 | 0         | Left to Right again ✅ |
