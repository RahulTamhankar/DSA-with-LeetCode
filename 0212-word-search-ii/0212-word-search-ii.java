class Solution {
    //Trie DataStructure 
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // eveny node will have children of size 26.We ask every node if you have child named a, b.. etc
        boolean endOfWord = false; //tells if any word has ended in current node
        String word = "";
    }

    List<String> result = new ArrayList<>();
    int rows, cols;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;

        //create a root node
        TrieNode root = getNode();

        //insert each word in words inside trie
        for (String word : words) {
            insert(root, word); // root ko bolo tu word ko insert karde apne me
        }

        //traverse in the grid(just once) and find all the words in tr ie if present
        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < cols; j++) {
                char ch = board[i][j];
                if (root.children[ch - 'a'] != null) { // root tere children me is ch ka node hai?
                    dfs(board, i, j, root); // agar ch hai to explore
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == '$' || root.children[board[i][j] - 'a'] == null) { // agar word ka character hi nai hai to bhi return karo ie last condition
            return;
        }

        // root ke ptr ko ch ke pass le jao
        char ch = board[i][j];
        root = root.children[ch - 'a'];

        // now jaha pe me root ko le gaya.. vahape koi root end ho raha hai kya
        if (root.endOfWord) {
            result.add(root.word);
            root.endOfWord = false; //uss word ko result me daldiya so backtrack 
        }

        char temp=board[i][j];
        board[i][j] = '$'; // mark current letter by $ before exploring further---> 1

        //keep exploring.. Eg bat and bate , so dont stop after bat
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            dfs(board, newI, newJ, root);
        }

        board[i][j] = temp; // mark unvisited
    }


    private void insert(TrieNode root, String word) {//start from root and put this word inside Trie
        TrieNode current = root; //crawler to crawl on trie
        for (char ch : word.toCharArray()) {
             //Crawler can you check each char and see if there is any child of this char 
            if (current.children[ch - 'a'] == null) {// means root ke pass child nahi hai uss char ka
                current.children[ch - 'a'] = getNode();// root ke pass child nahi hai to banalo
            }
            current = current.children[ch - 'a']; // move the pointer to the new TrieNode from root, root---b(ptr)
        }// at the end of this loop all the letters of each word will be added in trie 

        //when I am at the last of this node, I can say this is end of node
        current.endOfWord = true;
        current.word = word; //which word ? the one came from method signature
    }

    //Function which will return new new trie Node 
    // all the values will be initialized to null bydefault
    // When you create a new object like new TrieNode():All object references (like TrieNode[] children) are initialized to null by default.
    //All primitive types are initialized to their default values:int → 0 boolean → false String (an object) → null (unless explicitly assigned)
    private TrieNode getNode() {
        return new TrieNode();
    }
}
