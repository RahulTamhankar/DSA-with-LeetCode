class Solution {
public void rotate(int[][] matrix) {

    int n = matrix.length;

    for (int i = 0; i < (n + 1) / 2; i ++) {

      for (int j = 0; j < n / 2; j++) {
        // Start 4 way swaps
        // temp = bottom left
        int temp = matrix[n - 1 - j][i];

        // bottom left = bottom right
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];

        // bottom right = top right
        matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];

        // top right = top left
        matrix[j][n - 1 - i] = matrix[i][j];

        // top left = temp
        matrix[i][j] = temp;
      }
    }
  }
}


// int[][] matrix = {
//     {1, 2, 3},     // i=0
//     {4, 5, 6},     // i=1
//     {7, 8, 9}      // i=2
// };
// After rotating 90° clockwise:

// java
// Copy
// Edit
// int[][] rotated = {
//     {7, 4, 1},     // j=0
//     {8, 5, 2},     // j=1
//     {9, 6, 3}      // j=2
// };
// How?

// matrix[0][0] → rotated[0][2] → 1

// matrix[0][1] → rotated[1][2] → 2

// matrix[0][2] → rotated[2][2] → 3

// So general formula is:

// Copy
// Edit
// rotated[j][n - 1 - i] = matrix[i][j];
// \U0001f9e0 Summary:
// Expression	Meaning
// n - 1 - i	Mirror row index from bottom
// n - 1 - j	Mirror column index from right
// rotated[j][n-1-i]	90° clockwise rotation transformation

