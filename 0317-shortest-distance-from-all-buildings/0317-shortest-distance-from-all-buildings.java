import java.util.*;

public class Solution {
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] distSum = new int[rows][cols];
        int[][] reach = new int[rows][cols];

        int buildingCount = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Count buildings and BFS from each one
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    buildingCount++;
                    bfs(grid, row, col, distSum, reach, directions);
                }
            }
        }

        // Find the minimum distance where all buildings can reach
        int minDist = Integer.MAX_VALUE;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0 && reach[row][col] == buildingCount) {
                    minDist = Math.min(minDist, distSum[row][col]);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private void bfs(int[][] grid, int row, int col, int[][] distSum, int[][] reach, int[][] directions) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        
                        visited[newRow][newCol] = true;
                        distSum[newRow][newCol] += distance;
                        reach[newRow][newCol]++;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }
}
