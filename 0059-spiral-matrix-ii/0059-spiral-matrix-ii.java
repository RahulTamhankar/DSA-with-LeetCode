class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];

        int m = n;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        int dir = 0; // 0→, 1↓, 2←, 3↑

        int counter=1;
        while (top <= bottom && left <= right) {
            if (dir == 0) { // left to right
                for (int i = left; i <= right; i++) {
                    matrix[top][i]=counter++;
                }
                top++;
            } else if (dir == 1) { // top to bottom
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right]=counter++;
                }
                right--;
            } else if (dir == 2) { // right to left
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i]=counter++;
                }
                bottom--;
            } else if (dir == 3) { // bottom to top
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left]=counter++;
                }
                left++;
            }
            dir = (dir + 1) % 4; // rotate direction // OR keep doing dir++, if >3 back to 0
        }

        return matrix;
    }
}
