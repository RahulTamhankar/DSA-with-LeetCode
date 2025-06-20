import java.util.*;

class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        Queue<int[]> pq = new LinkedList<>();

        // Add all rotten oranges (value 2) to the queue
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    pq.offer(new int[]{i, j});
                }
            }
        }

        // BFS to spread the rotting process
        while (!pq.isEmpty()) {
            int sz = pq.size();
            int level = 0;
            while (sz-- > 0) {
                int[] p = pq.poll();
                int i = p[0];
                int j = p[1];

                for (int k = 0; k < 4; k++) {
                    int ii = i + dx[k];
                    int jj = j + dy[k];

                    if (ii >= 0 && jj >= 0 && ii < r && jj < c && grid[ii][jj] == 1) {
                        grid[ii][jj] = 2;
                        level = 1;
                        pq.offer(new int[]{ii, jj});
                    }
                }
            }

            ans += level;
        }

        // Final check for any remaining fresh oranges
        for (int[] row : grid) {
            for (int val : row) {
                if (val == 1) return -1;
            }
        }

        return ans;
    }
}
