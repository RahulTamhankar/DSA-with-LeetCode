import java.util.HashSet;

public class Solution {

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();

            for (int j = 0; j < n; j++) {
                rows.add(matrix[i][j]);
                cols.add(matrix[j][i]);
            }

            if (rows.size() != n || cols.size() != n) {
                return false;
            }
        }

        return true;
    }
}
