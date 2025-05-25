class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers or ending with 0 (but not 0 itself) can't be palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;

        while (x > reversedHalf) {
            int digit = x % 10;                // Get last digit
            reversedHalf = reversedHalf * 10 + digit; // Build reversed half
            x = x / 10;                         // Remove last digit
        }

        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf / 10 (middle digit doesn't matter)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
// \U0001f9ea Example: x = 1221
// Initial:

// x = 1221

// reversedHalf = 0

// Step 1:

// digit = 1221 % 10 = 1

// reversedHalf = 0 * 10 + 1 = 1

// x = 1221 / 10 = 122

// Step 2:

// digit = 122 % 10 = 2

// reversedHalf = 1 * 10 + 2 = 12

// x = 122 / 10 = 12

// Now:

// x = 12, reversedHalf = 12
// → x == reversedHalf → ✅ palindrome

// \U0001f9ea Example: x = 12321 (Odd length)
// Step 1:

// digit = 1 → reversedHalf = 1 → x = 1232
// Step 2:

// digit = 2 → reversedHalf = 12 → x = 123
// Step 3:

// digit = 3 → reversedHalf = 123 → x = 12

// Now:

// x = 12, reversedHalf = 123
// → x < reversedHalf, so we exit loop
// → check: x == reversedHalf / 10 → 12 == 123 / 10 → 12 == 12 ✅

// Odd digit middle (3) ignored.