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