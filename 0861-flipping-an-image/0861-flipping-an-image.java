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
//If col = 5, then:

// java
// Copy
// Edit
// (col + 1) / 2 = (5 + 1) / 2 = 6 / 2 = 3
// You get 3 iterations, which covers:

// index 0 ↔ 4

// index 1 ↔ 3

// index 2 ↔ itself (center element)

// The center element (at index 2) doesn’t move during a flip, but it still needs to be inverted, which is why we include it in the loop.

//-----------------------------------------

// class Solution {
//     public int[][] flipAndInvertImage(int[][] image) {
        
//         for(int[] arr : image){
//             reverse(arr);
//             invert(arr);
//         }
//         return image;
//     }

//     private void reverse(int[] arr) {
//         int start = 0;
//         int end   = arr.length - 1;

//        while(start < end) {
//             int temp  = arr[start];
//             arr[start] = arr[end];
//             arr[end]  = temp;

//             start += 1;
//             end   -= 1;
//        }  
//     }

//     private void invert(int[] arr) {
//         for(int i = 0; i < arr.length; i++) {
//             if(arr[i] == 0) arr[i] = 1;
//             else arr[i] = 0;
//         }
//     }
// }