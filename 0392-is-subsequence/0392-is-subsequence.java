// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         int m = s.length();
//         int n = t.length();

//         boolean[][] dp = new boolean[m + 1][n + 1];

//         // An empty string s is always a subsequence of any t
//         for (int j = 0; j <= n; j++) {
//             dp[0][j] = true;
//         }

//         // Fill the dp table
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = dp[i][j - 1];
//                 }
//             }
//         }

//         return dp[m][n];
//     }
// }

class Solution {
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        int i=0,j=0;
        while(i<m && j<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }
}

