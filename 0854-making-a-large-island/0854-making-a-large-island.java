import java.util.*;

class Solution {
    int id = 2;
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // First DFS pass to label islands with unique ids and store their areas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j, grid);
                    map.put(id, count);
                    id++;
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;
        
        // Check each 0 cell to see the maximum island we can get by flipping it
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int sum = 0;
                    
                    if (check(i - 1, j, grid, n, m) && grid[i - 1][j] > 1 && !set.contains(grid[i - 1][j])) {
                        set.add(grid[i - 1][j]);
                        sum += map.get(grid[i - 1][j]);
                    }
                    if (check(i + 1, j, grid, n, m) && grid[i + 1][j] > 1 && !set.contains(grid[i + 1][j])) {
                        set.add(grid[i + 1][j]);
                        sum += map.get(grid[i + 1][j]);
                    }
                    if (check(i, j - 1, grid, n, m) && grid[i][j - 1] > 1 && !set.contains(grid[i][j - 1])) {
                        set.add(grid[i][j - 1]);
                        sum += map.get(grid[i][j - 1]);
                    }
                    if (check(i, j + 1, grid, n, m) && grid[i][j + 1] > 1 && !set.contains(grid[i][j + 1])) {
                        set.add(grid[i][j + 1]);
                        sum += map.get(grid[i][j + 1]);
                    }
                    
                    ans = Math.max(ans, sum + 1);
                }
            }
        }
        
        return ans == Integer.MIN_VALUE ? n * m : ans;
    }
    
    // DFS to label islands with a unique id and count their area
    private void dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1) {
            grid[i][j] = id;
            count++;
            dfs(i - 1, j, grid);
            dfs(i + 1, j, grid);
            dfs(i, j - 1, grid);
            dfs(i, j + 1, grid);
        }
    }
    
    // Check if (i,j) is within grid bounds
    private boolean check(int i, int j, int[][] grid, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
