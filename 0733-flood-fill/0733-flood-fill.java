class Solution {

    private static final int[] dx={-1,0,1,0};
    private static final int[] dy={0,1,0,-1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r=image.length;
        int c=image[0].length;

        int orgColor=image[sr][sc];

        if(orgColor==color){
            return image;
        }
        bfs(sr,sc,orgColor,color,r,c,image);
        return image;
    }

    private static void bfs(int sr,int sc,int orgColor,int color,int r,int c,int[][] image){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc]=color;

        while(!q.isEmpty()){
            int[] f=q.poll();
            int i=f[0];
            int j=f[1];

            for(int k=0;k<4;k++){
                int ii=i+dx[k];
                int jj=j+dy[k];

                if(ii<0 || jj<0 || ii>=r || jj>=c || image[ii][jj]!=orgColor){
                    continue;
                }


                image[ii][jj]=color;
                q.add(new int[]{ii,jj});
            }
        }
    } 
}