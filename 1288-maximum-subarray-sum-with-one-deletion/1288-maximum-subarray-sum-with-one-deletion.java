// class Solution {
//     public int maximumSum(int[] arr) {
//         int n = arr.length;
//         int[] noDel = new int[n]; // no deletion
//         int[] oneDel = new int[n]; // one deletion

//         noDel[0] = arr[0];
//         oneDel[0] = arr[0];
//         int res = arr[0];

//         for (int i = 1; i < n; i++) {
//             noDel[i] = Math.max(noDel[i - 1] + arr[i], arr[i]);
//             oneDel[i] = Math.max(noDel[i - 1], oneDel[i - 1] + arr[i]);
//             res = Math.max(res, Math.max(noDel[i], oneDel[i]));
//         }

//         return res;
//     }
// }


// //https://www.youtube.com/watch?v=QtqvT9u4IPc

// Space Optimization (O(1))
// Since each state only depends on the previous index, we can reduce from O(n) space to O(1):

class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int noDel = arr[0];
        int oneDel = arr[0];
        int res = arr[0];

        for (int i = 1; i < n; i++) {
            int newNoDel = Math.max(arr[i], noDel + arr[i]);
            int newOneDel = Math.max(noDel, oneDel + arr[i]);
            res = Math.max(res, Math.max(newNoDel, newOneDel));
            noDel = newNoDel;
            oneDel = newOneDel;
        }

        return res;
    }
}