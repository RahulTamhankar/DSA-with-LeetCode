class Solution {
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // DFS from Pacific Ocean borders (top and left)
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, heights, pacific);        // Left edge — Pacific
            dfs(i, cols - 1, heights, atlantic); // Right edge — Atlantic
        }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, heights, pacific);        // Top edge — Pacific
            dfs(rows - 1, j, heights, atlantic); // Bottom edge — Atlantic
        }


        // Collect cells reachable by both oceans
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] ocean) {
        ocean[i][j] = true;
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || nj < 0 || ni >= rows || nj >= cols) continue;
            if (ocean[ni][nj]) continue;
            if (heights[ni][nj] < heights[i][j]) continue;
            dfs(ni, nj, heights, ocean);
        }
    }
}
