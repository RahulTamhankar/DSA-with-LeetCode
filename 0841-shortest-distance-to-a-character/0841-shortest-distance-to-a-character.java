class Solution {
    public int[] shortestToChar(String s, char c) {
        int n=s.length();
        int pos=-n;//any number fine;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)==c){
                pos=i;
            }
            res[i]=i-pos;
        }
        for(int i=pos-1;i>=0;i--){
            if(s.charAt(i)==c){
                pos=i;
            }
            res[i]=Math.min(res[i],pos-i);
        }
        return res;
    }
}








//     public int[] shortestToChar(String S, char C) {
//         int n = S.length();
//         int[] res = new int[n];
//         for (int i = 0; i < n; ++i)
//             res[i] = S.charAt(i) == C ? 0 : n;
//         for (int i = 1; i < n; ++i)
//             res[i] = Math.min(res[i], res[i - 1] + 1);
//         for (int i = n - 2; i >= 0; --i)
//             res[i] = Math.min(res[i], res[i + 1] + 1);
//         return res;
//     }


// What It Does:
// Given a string S and a character C, it builds an array res[] such that for each index i, res[i] contains the shortest distance from index i to any occurrence of the character C.

// \U0001f9e9 Code Walkthrough
// java
// Copy
// Edit
// public int[] shortestToChar(String S, char C) {
//     int n = S.length();
//     int[] res = new int[n];
// n: length of the input string.

// res[]: the result array to hold distances.

// \U0001f501 Pass 1: Initialization
// java
// Copy
// Edit
// for (int i = 0; i < n; ++i)
//     res[i] = S.charAt(i) == C ? 0 : n;
// If S[i] == C, distance is 0 (we’re at the target character).

// If not, set it to a large number (n, the maximum possible distance) as a placeholder.

// \U0001f4cc Example:
// If S = "loveleetcode" and C = 'e', after this loop:

// java
// Copy
// Edit
// res = [12, 12, 12, 0, 12, 0, 0, 12, 12, 12, 12, 0]
// \U0001f501 Pass 2: Left to Right
// java
// Copy
// Edit
// for (int i = 1; i < n; ++i)
//     res[i] = Math.min(res[i], res[i - 1] + 1);
// If current character isn’t 'C', we update its value to be 1 more than the previous distance.

// This effectively propagates distances from left to right.

// \U0001f4cc Example (partial result):

// java
// Copy
// Edit
// res = [12, 13, 14, 0, 1, 0, 0, 1, 2, 3, 4, 0]
// \U0001f501 Pass 3: Right to Left
// java
// Copy
// Edit
// for (int i = n - 2; i >= 0; --i)
//     res[i] = Math.min(res[i], res[i + 1] + 1);
// Same idea, but now we check if we can get a shorter distance from the right side.

// \U0001f4cc Final result:

// java
// Copy
// Edit
// res = [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
// \U0001f9e0 How It Works:
// First pass: marks locations of C (with 0), everything else as far away.

// Second pass: spreads distance from left.

// Third pass: spreads distance from right, taking the minimum of both.

// \U0001f527 Compared to the Other Approach:
// Feature	This Method	Previous Method (two for loops)
// Passes	3	2
// Distance Propagation Style	Like dynamic programming	Explicit tracking of 'C' index
// Readability	Clean and concise	Slightly more logic-heavy
// Efficiency	O(n) time and O(n) space	Same (O(n) time, O(n) space)