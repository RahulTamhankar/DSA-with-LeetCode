class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int n = board.length;
        int m = board[0].length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = i - 1;
                int left = j - 1;

                if (board[i][j] == 'X' &&
                    (left < 0 || board[i][left] == '.') &&
                    (top < 0 || board[top][j] == '.')) {
                    total++;
                }
            }
        }

        return total;
    }
}
