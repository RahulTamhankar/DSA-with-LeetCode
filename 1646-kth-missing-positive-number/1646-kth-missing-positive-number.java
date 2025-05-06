// class Solution {
//     public int findKthPositive(int[] arr, int k) {
//         int current = 1;  // Start checking from 1
//         int i = 0;        // Pointer for arr

//         while (k > 0) {
//             if (i < arr.length && arr[i] == current) {
//                 i++; // current number is in arr, skip it
//             } else {
//                 k--; // current number is missing
//                 if (k == 0) return current;
//             }
//             current++;
//         }

//         return -1; // Just in case, though it should never hit
//     }
// }


class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int left = 0;
        int right = arr.length -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            int missing = arr[mid] -(mid+1);

            if(missing < k){
                left = mid +1;
            }
            else{
                right = mid-1;
            }
        }

        return left + k;
    }
}


// Here the expected arr is same as the index+1
// ie[1 2 3 4 5..] same as index[0 1 2 3 4..]
// hence the missing number will be actual - expected or actual -(i+1)


// The formula:

// java
// Copy
// Edit
// missing = arr[mid] - (mid + 1)
// tells you how many positive integers are missing from the beginning up to index mid.

// \U0001f9e0 Why does this work?
// If no numbers were missing, we would expect:

// Copy
// Edit
// arr[i] == i + 1
// So if you subtract:

// css
// Copy
// Edit
// arr[i] - (i + 1)
// You get the count of missing numbers before arr[i].

// \U0001f50d Example:
// java
// Copy
// Edit
// arr = [2, 3, 4, 7, 11]
// index i:  0   1   2   3   4
// expected: 1   2   3   4   5
// Let's compute:
// i	arr[i]	expected	missing = arr[i] - (i+1)
// 0	2	1	2 - 1 = 1
// 1	3	2	3 - 2 = 1
// 2	4	3	4 - 3 = 1
// 3	7	4	7 - 4 = 3
// 4	11	5	11 - 5 = 6

// So:

// At i = 3, 3 numbers are missing before 7.

// At i = 4, 6 numbers are missing before 11.

// Summary:
// arr[mid] - (mid + 1) ≠ expected index

// It = how many numbers are missing before arr[mid]

// That’s exactly what we need to compare against k