class Solution {
    
    private static final int[] dx={-1,1,0,0};
    private static final int[] dy={0,0,-1,1};
    
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int cnt=0;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;    
    }

    private static void dfs(char[][]grid,int i,int j){
        if(i<0 || i>=grid.length ||j<0 ||j>=grid[0].length || grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';

        for(int k=0;k<4;k++){
            int ii=i+dx[k];
            int jj=j+dy[k];
            dfs(grid,ii,jj);
        }
    }
}

// Input grid:
// [
//   ['1','1','0','0','0'],
//   ['1','1','0','0','0'],
//   ['0','0','1','0','0'],
//   ['0','0','0','1','1']
// ]

// ▶ Step-by-Step Traversal (First Island)
// Starting point: (0,0) — first '1' found → call dfs(0,0).

// dfs(0,0):

// Mark (0,0) as '2'

// Try neighbors:

// (−1,0) → invalid

// (1,0) → '1' → dfs(1,0)

// dfs(1,0):

// Mark (1,0) as '2'

// Try neighbors:

// (0,0) → already '2'

// (2,0) → '0' → return

// (1,−1) → invalid

// (1,1) → '1' → dfs(1,1)

// dfs(1,1):

// Mark (1,1) as '2'

// Try neighbors:

// (0,1) → '1' → dfs(0,1)

// dfs(0,1):

// Mark (0,1) as '2'

// All neighbors either '0' or '2' → backtrack

// Backtrack from all calls — first island fully explored.

// \U0001f3dd️ New Island Triggers
// Continue the loop:

// At (0,2) → '0'

// At (1,2) → '0'

// At (2,2) → '1' → new island → call dfs(2,2)

// Only this cell → no further '1' neighbors → done

// Then:

// At (3,3) → '1' → new island → call dfs(3,3)

// Leads to (3,4) → '1' → marked

// No more '1' neighbors → done

// \U0001f9ee Final Count
// Island 1: From (0,0)

// Island 2: From (2,2)

// Island 3: From (3,3)

// cnt = 3