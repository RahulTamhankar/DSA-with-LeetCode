class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
        String word = "";
    }

    List<String> result = new ArrayList<>();
    int rows, cols;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;

        TrieNode root = getNode();
        for (String word : words) {
            insert(root, word);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = board[i][j];
                if (root.children[ch - 'a'] != null) {
                    dfs(board, i, j, root);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == '$' || root.children[board[i][j] - 'a'] == null) {
            return;
        }

        char ch = board[i][j];
        root = root.children[ch - 'a'];

        if (root.endOfWord) {
            result.add(root.word);
            root.endOfWord = false;
        }

        board[i][j] = '$';

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            dfs(board, newI, newJ, root);
        }

        board[i][j] = ch;
    }

    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = getNode();
            }
            current = current.children[ch - 'a'];
        }
        current.endOfWord = true;
        current.word = word;
    }

    private TrieNode getNode() {
        return new TrieNode();
    }
}
