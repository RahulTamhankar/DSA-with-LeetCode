// // Approach-1 (Recur + Memoization)
// // T.C : O(m*n)
// // S.C : O(m*n)
// class Solution {
//     private int MPS(int[][] grid, int i, int j, int m, int n, int[][] t) {
//         if (i == m - 1 && j == n - 1)
//             return t[i][j] = grid[i][j];
//         if (t[i][j] != -1)
//             return t[i][j];
//         if (i == m - 1) { // we can only go right
//             return t[i][j] = grid[i][j] + MPS(grid, i, j + 1, m, n, t);
//         } else if (j == n - 1) { // we can only go down
//             return t[i][j] = grid[i][j] + MPS(grid, i + 1, j, m, n, t);
//         } else {
//             return t[i][j] = grid[i][j] + Math.min(MPS(grid, i + 1, j, m, n, t), MPS(grid, i, j + 1, m, n, t));
//         }
//     }

//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int[][] t = new int[m][n];
//         for (int[] row : t) {
//             Arrays.fill(row, -1);
//         }
//         return MPS(grid, 0, 0, m, n, t);
//     }
// }

// Approach-2 (Bottom Up DP)
// T.C : O(m*n)
// S.C : O(m*n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];

        // Fill first column
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        // Fill first row
        for(int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        
        // Fill the rest of the table
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}