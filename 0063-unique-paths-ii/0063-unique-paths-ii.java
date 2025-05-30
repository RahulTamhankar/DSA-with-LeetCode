public class Solution {
    private int m, n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        return solve(obstacleGrid);
    }

    private int solve(int[][] obstacleGrid) {
        int[][] t = new int[m][n];

        if (obstacleGrid[0][0] == 1)
            return 0;

        // Fill first row
        for (int col = 0; col < n; col++) {
            if (col > 0 && obstacleGrid[0][col - 1] == 1) {
                t[0][col] = 0;
                obstacleGrid[0][col] = 1; // Block further cells in the row
            } else if (obstacleGrid[0][col] == 1) {
                t[0][col] = 0;
            } else {
                t[0][col] = 1;
            }
        }

        // Fill first column
        for (int row = 0; row < m; row++) {
            if (row > 0 && obstacleGrid[row - 1][0] == 1) {
                t[row][0] = 0;
                obstacleGrid[row][0] = 1; // Block further cells in the column
            } else if (obstacleGrid[row][0] == 1) {
                t[row][0] = 0;
            } else {
                t[row][0] = 1;
            }
        }

        // Fill rest of the table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    t[i][j] = 0;
                } else {
                    t[i][j] = t[i - 1][j] + t[i][j - 1];
                }
            }
        }

        return t[m - 1][n - 1];
    }
}
