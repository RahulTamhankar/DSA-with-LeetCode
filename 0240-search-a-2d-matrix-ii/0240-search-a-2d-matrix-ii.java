//tc-o(n*m) ,sc-o(1)
// indirect concept of binary search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int row=0,col=n-1;

        while(row<m && col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]<target){
                row++;
            }else{
                col--;
            }
        }
    return false;
    }
}