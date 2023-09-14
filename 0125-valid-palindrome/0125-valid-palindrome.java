class Solution {
    public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        s = s.trim();
        if(s.isEmpty())
            return true;
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int left = 0, right = s.length() - 1; left < right; left++, right--) {
            char ch1 = s.charAt(left);
            char ch2 = s.charAt(right);
            if(ch1 != ch2)
                return false;
        }

        return true;
    }
}