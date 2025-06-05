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

// Why col--?
// You start at the top-right corner: mat[0][n - 1].

// Now consider the value at mat[row][col]:

// If mat[row][col] > target:
// → All elements below it in the same column will be even larger (because columns are sorted).
// → So, you can’t go down.
// → But you might find a smaller number to the left, so:
// ✅ Move left by doing col--.

