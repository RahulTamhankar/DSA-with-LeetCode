class Solution { 
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        // 'right' is declared in the for loop and used properly within it
        for (int right = 0; right < s.length(); right++) {

            // If character is already in the set, remove characters from the left
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++; // Move the left pointer to shrink the window
            }

            // Now add the current character since it's unique in the current window
            charSet.add(s.charAt(right));

            // Update maxLength if the current window is larger
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; // Return the length of the longest substring
    }
}
