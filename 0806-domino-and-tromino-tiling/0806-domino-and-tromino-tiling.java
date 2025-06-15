// //Approach-1 (Recur + Memo)
// //T.C : O(n)
// //S.C : O(n)
// class Solution {
//     final int M = 1000000007;
//     int[] t = new int[1001];

//     public int solve(int n) {
//         if (n == 1 || n == 2)
//             return n;
//         if (n == 3)
//             return 5;

//         if (t[n] != -1)
//             return t[n];

//         t[n] = (int)((2L * solve(n - 1) % M + solve(n - 3)) % M);
//         return t[n];
//     }

//     public int numTilings(int n) {
//         // Initialize memoization array with -1
//         for (int i = 0; i <= n; i++) {
//             t[i] = -1;
//         }

//         return solve(n);
//     }
// }


//Approach-2 (Bottom Up)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int numTilings(int n) {
        final int M = 1000000007;

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        int[] t = new int[n + 1];

        t[1] = 1;
        t[2] = 2;
        t[3] = 5;

        for (int i = 4; i <= n; i++) {
            t[i] = (int)((2L * t[i - 1] % M + t[i - 3]) % M);
        }

        return t[n];
    }
}