class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        // Check if reshape is possible
        if (m * n != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];
        int row = 0, col = 0;

        // Traverse original matrix and fill the new matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return ans;
    }
}
