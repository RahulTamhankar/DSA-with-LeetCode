class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charCount[i]);// 1st word e=1 l=2, 2nd word e=1,l=1 so we take min ie e=1 and l=1
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(Character.toString((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return result;
    }
}

//  Line-by-Line Breakdown:
// 1. List<String> result = new ArrayList<>();
// This initializes an empty list to hold the final result — the common characters.

// 2. for (int i = 0; i < 26; i++) {
// Loop over indices 0 to 25, representing letters 'a' to 'z'.

// 3. while (minFreq[i] > 0) {
// If the character corresponding to this index appears at least once in all words, enter the loop.

// 4. result.add(Character.toString((char) (i + 'a')));
// This converts the index i to its corresponding character:

// i = 0 → 'a', i = 1 → 'b', ..., i = 25 → 'z'

// Then it converts that character to a String (because List<String> holds strings).

// Adds the character to the result.

// 5. minFreq[i]--;
// Decreases the frequency count by 1, so if minFreq[i] = 2, this loop runs twice.


