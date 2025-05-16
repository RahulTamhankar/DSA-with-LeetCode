class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        String ans = "";

        // dp[i][j] = true if s[i..j] is a palindrome
        int[][] dp = new int[n][n];

        for (int diff = 0; diff < n; diff++) {
            for (int i = 0, j = i + diff; j < n; i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (diff == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 0;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }

                //This ensures you only update the result ans when a longer palindrome is found.
                if (dp[i][j] != 0) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }

        return ans;
    }
}


//Approach 1 - Recursion + Memoization
//T.C : O(n^2) - Because the AMortized Time Complexity of solve() will become 1 due to memoization.
//S.C : O(n^2)
// public class Solution {
//     private int[][] t;

//     public String longestPalindrome(String s) {
//         int n = s.length();
//         int maxlen = Integer.MIN_VALUE;
//         int startingIndex = 0;
//         t = new int[n][n];
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(t[i], -1);
//         }

//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 if (solve(s, i, j) && j - i + 1 > maxlen) {
//                     startingIndex = i;
//                     maxlen = j - i + 1;
//                 }
//             }
//         }

//         return s.substring(startingIndex, startingIndex + maxlen);
//     }

//     private boolean solve(String s, int l, int r) {
//         if (l >= r) {
//             return true;
//         }

//         if (t[l][r] != -1) {
//             return t[l][r] == 1;
//         }

//         if (s.charAt(l) == s.charAt(r)) {
//             t[l][r] = solve(s, l + 1, r - 1) ? 1 : 0;
//         } else {
//             t[l][r] = 0;
//         }

//         return t[l][r] == 1;
//     }
// }
