// //Approach-1 (Simple Brute Force) - TLE
// //T.C : O(n^2)
// //S.C : O(1)
// class Solution {
//     final int M = 1000000007;

//     public int sumSubarrayMins(int[] arr) {
//         int n = arr.length;
//         long result = 0;

//         for (int i = 0; i < n; i++) {
//             int minVal = arr[i];

//             for (int j = i; j < n; j++) {
//                 minVal = Math.min(minVal, arr[j]);
//                 result = (result + minVal) % M;
//             }
//         }

//         return (int) result;
//     }
// }


//Approach-2
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }

    public int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return result;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long sum = 0;
        int M = 1000000007;

        for (int i = 0; i < n; i++) {
            long ls = i - NSL[i]; //left me kitne elements honge
            long rs = NSR[i] - i; //right me.......
            
            long totalWaysForIMin = ls * rs; //total subarrays honge jinka minimum arr[i]
            long sumIInTotalWays = arr[i] * totalWaysForIMin;

            sum = (sum + sumIInTotalWays) % M; //%M bcoz given in Question
        }

        return (int) sum;
    }
}