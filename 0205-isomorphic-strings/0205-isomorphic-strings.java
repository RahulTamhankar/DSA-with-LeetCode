class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> charMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);

            if(charMap.containsKey(sc)){
                if(charMap.get(sc)!=tc){
                    return false;
                }
            }else if(charMap.containsValue(tc)){
                return false;
            }
            charMap.put(sc,tc);
        }
        return true;
    }
}

// HashMap<Character, Character> charMap = new HashMap<>();
// This map stores a character from s as a key and its corresponding character from t as the value.

// Ensures the same character in s always maps to the same character in t.

// if (charMap.containsKey(sc)) {
//     if (charMap.get(sc) != tc) {
//         return false;
//     }
// If sc is already mapped, check if it's mapped to the correct tc.

// If not, there's a conflict → return false.

// java
// Copy
// Edit
// } else if (charMap.containsValue(tc)) {
//     return false;
// }
// If sc isn't yet mapped, check if any other key is already mapped to tc.

// Prevents two s characters mapping to the same t character — enforces one-to-one.

