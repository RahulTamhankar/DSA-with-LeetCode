// //Approach-1 (Using Recursion + Memoization)
// //T.C : O(n) after memoization (without memoization - O(2^n)
// //S.C : O(101) ~= O(1)
// public class Solution {
//     private int[] t;

//     public int solve(int i, String s, int n) {
//         if (t[i] != -1) {
//             return t[i];
//         }

//         if (i == n) {
//             return t[i] = 1; // one valid split done
//         }

//         if (s.charAt(i) == '0') {
//             return t[i] = 0; // not possible to split
//         }

//         int result = solve(i + 1, s, n);

//         if (i + 1 < n) {
//             if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))
//                 result += solve(i + 2, s, n);
//         }

//         return t[i] = result;
//     }

//     public int numDecodings(String s) {
//         int n = s.length();
//         t = new int[101];
//         Arrays.fill(t, -1);
//         return solve(0, s, n);
//     }
// }


//Approach-2 (Bottom Up Way-1)
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public int bottomUp1(String s, int n) {
        int[] t = new int[n + 1];
        ////t[i] = ways to decode string from index i to n
        Arrays.fill(t, 0);
        t[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                t[i] = 0;
            } else {
                t[i] = t[i + 1];
                if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    t[i] += t[i + 2];
                }
            }
        }
        return t[0];
    }

    public int numDecodings(String s) {
        int n = s.length();
        return bottomUp1(s, n);
    }
}


// //Approach-4 
// //T.C : O(n)
// //S.C : O(1)
// public class Solution {
//     public int numDecodings(String s) {
//         int n = s.length();
//         if (n == 1) {
//             return s.charAt(0) == '0' ? 0 : 1;
//         }
//         if (s.charAt(0) == '0') {
//             return 0;
//         }

//         int last1 = 1, last2 = 1;

//         for (int i = 1; i < n; i++) {
//             int count = s.charAt(i) != '0' ? last1 : 0;

//             if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')) {
//                 count += last2;
//             }

//             last2 = last1;
//             last1 = count;
//         }

//         return last1;
//     }
// }

// Role of last1 and last2
// last1: number of decoding ways up to index i-1
// last2: number of decoding ways up to index i-2
// We initialize:
// last1 = 1 → for the first char (valid single-digit decoding)
// last2 = 1 → base case for the empty string (1 way to decode nothing)
// Input: "226"
// We're finding how many ways to decode "226" where:

// '2' → 'B'

// '22' → 'V'

// '26' → 'Z'

// \U0001f9e0 Initialization
// java
// Copy
// Edit
// int last1 = 1;   // Decodings up to index 0
// int last2 = 1;   // Decodings up to -1 (empty string base case)
// \U0001f9ee Iteration Steps
// We'll loop from i = 1 to i = 2 (since n = 3)

// ✅ i = 1 → current char = '2'
// → previous char = '2'
// → substring = "22"

// Step 1: One-digit check → '2' is valid
// java
// Copy
// Edit
// count = last1 = 1
// Step 2: Two-digit check → '22' is between "10" and "26"
// java
// Copy
// Edit
// count += last2 → 1 + 1 = 2
// Update:
// java
// Copy
// Edit
// last2 = last1 = 1
// last1 = count = 2
// \U0001f9fe At this point:

// "2 2" → "BB"

// "22" → "V"

// ✅ i = 2 → current char = '6'
// → previous char = '2'
// → substring = "26"

// Step 1: One-digit check → '6' is valid
// java
// Copy
// Edit
// count = last1 = 2
// Step 2: Two-digit check → "26" is valid (≤ 26)
// java
// Copy
// Edit
// count += last2 → 2 + 1 = 3
// Update:
// java
// Copy
// Edit
// last2 = last1 = 2
// last1 = count = 3
// \U0001f9fe Now we have:

// "2 2 6" → "B B F"

// "22 6" → "V F"

// "2 26" → "B Z"

// ✅ Final Return:
// java
// Copy
// Edit
// return last1;  // 3
// ✅ Final Answer:
// There are 3 ways to decode "226":

// '2' '2' '6' → 'B' 'B' 'F'

// '22' '6' → 'V' 'F'

// '2' '26' → 'B' 'Z'