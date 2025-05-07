class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int C=image[0].length;
        for(int[] row:image){
            for(int i=0;i<(C+1)/2;i++){
                int temp=row[i]^1;
                row[i]=row[C-1-i]^1;
                row[C-1-i]=temp;
            }
        }
        return image;
    }
}