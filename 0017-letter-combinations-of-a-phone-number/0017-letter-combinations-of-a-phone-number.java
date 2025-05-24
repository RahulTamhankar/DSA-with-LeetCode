class Solution {

    private void helper(int idx, String digits, Map<Character, String> mapping, StringBuilder currStr, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(currStr.toString());
            return;
        }

        char ch = digits.charAt(idx);
        String letters = mapping.get(ch);

        for (char letter : letters.toCharArray()) {
            currStr.append(letter);
            helper(idx + 1, digits, mapping, currStr, ans);
            currStr.deleteCharAt(currStr.length() - 1); // backtrack
        }
    }

        public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;

        Map<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        helper(0, digits, mapping, new StringBuilder(), ans);
        return ans;
    }

}
