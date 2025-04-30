class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n]; // LPS (Longest Prefix which is also Suffix) array

        int len = 0; // length of the current longest prefix-suffix
        int i = 1;   // start from second character

        // Build the LPS array
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                // When characters match, increase length and assign it to lps[i]
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Try the previous longest prefix-suffix
                    len = lps[len - 1];
                    // No i++ here — try matching with shorter prefix
                } else {
                    // No prefix-suffix match at all
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int longestPrefixSuffix = lps[n - 1]; // Value at the end of the LPS array

        // Check if the string can be constructed by repeating a substring
        // Rule: length of string must be divisible by the length of the repeating unit
        // Repeating unit length = n - longestPrefixSuffix
        return longestPrefixSuffix > 0 && n % (n - longestPrefixSuffix) == 0;
    }
}


// \U0001f9e0 What’s going on?
// We're comparing:

// s.charAt(i) — the current character

// with s.charAt(len) — the current prefix-suffix candidate

// If they don’t match, we need to decide:

// Should we try a shorter possible prefix-suffix? Or give up and move on?

// ✅ Case 1: len != 0
// There was a match up to some point, but now it broke.

// Instead of starting over from scratch, we try the next best smaller prefix — which is lps[len - 1].

// Why? Because:

// We already know that lps[len - 1] is a valid prefix-suffix.

// Maybe we can still salvage a match by backing up and comparing a smaller piece.

// Key Point:
// We don’t increment i here because we're still trying to fix the current character s[i] by matching it against a smaller prefix.

// ❌ Case 2: len == 0
// No matching prefix-suffix found so far.

// So we give up and just say: no match at this point → lps[i] = 0

// Then move forward with i++.

// \U0001f9ea Example: "abacab" (Building LPS array)
// Let’s walk through part of it:


// i	s[i]	len	Match?	Action	LPS[i]
// 1	b	0	✘	len==0 → lps=0	0
// 2	a	0	✔	len++	1
// 3	c	1	✘	fallback to lps[0] = 0	—
// 3	c	0	✘	lps=0, i++	0
// See how we don’t move i when len != 0, but instead try a smaller prefix?

// ✅ Summary:
// This part helps us efficiently backtrack in the prefix when a mismatch happens.
// It's what makes KMP linear time — instead of rechecking from the beginning, it jumps to the best known possible match using the LPS array itself.

// Would you like a full step-by-step LPS array build for an example like "abab"?
