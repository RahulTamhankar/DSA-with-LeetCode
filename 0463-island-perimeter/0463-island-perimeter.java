class Solution {
    int count=0;
    public int islandPerimeter(int[][] grid) {
        count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    break;   //if there are more than 1 island then remove this break
                }
            }
        }
        return count;
    }

    private void dfs(int[][]grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0){
            count++;
            return;
        }
        if(grid[i][j]==-1) return;

        grid[i][j]=-1;  // if we get 0 we do count++, if its 1 we do -1 and if its -1 we do simple return

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
// }                                                                                                                                   Just using break exits the inner loop, but the outer loop still runs. If you don’t prevent that, you’ll keep looping through the rest of the grid even though you're done. or just return count instead of break to come out of both loops