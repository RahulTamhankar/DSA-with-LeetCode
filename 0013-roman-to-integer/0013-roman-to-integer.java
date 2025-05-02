import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        // Define Roman numeral values
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // If next character exists and current value is less than next, subtract
            if (i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                res += roman.get(s.charAt(i));
            }
        }

        return res;
    }
}
