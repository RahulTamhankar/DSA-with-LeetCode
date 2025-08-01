// class Solution {
//     private int m, n;
//     private int emptyCells;
//     private int result = 0;
//     private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
//     public int uniquePathsIII(int[][] grid) {
//         m = grid.length;
//         n = grid[0].length;
//         emptyCells = 0;
//         result = 0;

//         int startX = 0, startY = 0;

//         // Count empty cells and find starting point
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == 0) {
//                     emptyCells++;
//                 } else if (grid[i][j] == 1) {
//                     startX = i;
//                     startY = j;
//                 }
//             }
//         }

//         // Include the start cell in the count
//         emptyCells += 1;

//         dfs(grid, 0, startX, startY);

//         return result;
//     }

//     private void dfs(int[][] grid, int currCount, int i, int j) {
//         if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
//             return;
//         }

//         if (grid[i][j] == 2) {
//             if (currCount == emptyCells - 1) {
//                 result++;
//             }
//             return;
//         }

//         // Save current cell state and mark as visited
//         int temp = grid[i][j];
//         grid[i][j] = -1;

//         for (int[] dir : directions) {
//             int nextI = i + dir[0];
//             int nextJ = j + dir[1];
//             dfs(grid, currCount + 1, nextI, nextJ);
//         }

//         // Backtrack
//         grid[i][j] = temp;
//     }
// }


class Solution {
    private int m, n;
    private int totalSquaresToVisit;
    private int result = 0;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        totalSquaresToVisit = 0;
        result = 0;

        int startX = 0, startY = 0;

        // Count empty cells and find starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    totalSquaresToVisit++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    totalSquaresToVisit++;  // count start as part of total
                }
            }
        }

        dfs(grid, startX, startY, 0);
        return result;
    }

    private void dfs(int[][] grid, int i, int j, int steps) {
        // Out of bounds or hitting an obstacle
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return;
        }

        // If we've reached the end
        if (grid[i][j] == 2) {
            if (steps == totalSquaresToVisit) {
                result++;
            }
            return;
        }

        int temp = grid[i][j];
        grid[i][j] = -1; // mark as visited

        for (int[] dir : directions) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            dfs(grid, nextI, nextJ, steps + 1);
        }

        grid[i][j] = temp; // backtrack
    }
}
