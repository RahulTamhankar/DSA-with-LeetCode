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
