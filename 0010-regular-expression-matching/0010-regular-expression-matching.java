// //Approach-1 (Using Recursion)
// //T.C : In worst case, the function may recursively call itself twice for each character in the pattern (due to *), leading to an exponential number of recursive calls.
//         //Hence, time complexity will be approaximately O(2^(max(n, m))). where n , m are lengths of s and p respectively.
// //S.C : O(m) - Recursion stack space : where m = length of pattern (maximum depth of recursion tree)
//         //NOTE : We are passing substr to isMatch every time and hence they are being copied to x and p so, we will be creating O(2^(max(n, m))) number of substrings.
// public class Solution {
//     public boolean isMatch(String text, String pattern) {
//         if (pattern.length() == 0) {
//             return text.length() == 0;
//         }

//         boolean firstCharMatched = false;
//         if (text.length() > 0 && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.')) {
//             firstCharMatched = true;
//         }

//         // Best example to understand: s = "aaab", p = "a*b"
//         if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
//             return (isMatch(text, pattern.substring(2)) ||
//                     (firstCharMatched && isMatch(text.substring(1), pattern)));
//         } else {
//             return firstCharMatched && isMatch(text.substring(1), pattern.substring(1));
//         }
//     }
// }


//Approach-2 (Recursion + Memoization)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    int[][] t;

    public boolean solve(int i, int j, String text, String pattern) {
        if (j == pattern.length()) {
            return i == text.length();
        }

        if (t[i][j] != -1) {
            return t[i][j] == 1;
        }

        boolean ans = false;

        boolean first_match = (i < text.length() &&
                (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            ans = (solve(i, j + 2, text, pattern) ||
                    (first_match && solve(i + 1, j, text, pattern)));
        } else {
            ans = first_match && solve(i + 1, j + 1, text, pattern);
        }

        return (t[i][j] = ans ? 1 : 0) == 1;
    }

    public boolean isMatch(String text, String pattern) {
        t = new int[21][21];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, text, pattern);
    }
}