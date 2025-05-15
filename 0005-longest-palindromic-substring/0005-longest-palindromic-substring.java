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

