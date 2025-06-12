class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length==0) return 0;
        int[][] dpr = new int[grid.length+1][grid[0].length+1];
        int[][] dpc = new int[grid.length+1][grid[0].length+1];
        int dist, max=0;
        for (int r=1;r<=grid.length;r++){
            for (int c=1;c<=grid[0].length;c++){
                if (grid[r-1][c-1]==0) continue;
                dpr[r][c] = dpr[r-1][c]+1;
                dpc[r][c] = dpc[r][c-1]+1;
                dist = Math.min(dpr[r][c],dpc[r][c]);
                for (int i=dist;i>=1;i--){
                    if (dpr[r][c-i+1]>=i 
                        && dpc[r-i+1][c]>=i){
                        max = Math.max(max, i*i);
                        break;
                    }
                }
            }
        }
        return max;
    }
}