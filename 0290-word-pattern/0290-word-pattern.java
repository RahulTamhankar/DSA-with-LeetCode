class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");

        if(pattern.length()!=words.length) return false;

        Map<Character,String> charToWord=new HashMap<>();
        Map<String,Character> wordToChar=new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            String word=words[i];

            if(charToWord.containsKey(c)){
                if(!charToWord.get(c).equals(word)){
                    return false;
                }
            }else{
                charToWord.put(c,word);
            }

            if(wordToChar.containsKey(word)){
                if(wordToChar.get(word)!=c){
                    return false;
                }
            }else{
                wordToChar.put(word,c);
            }
        }
        return true;
    }
}

// explain why 2 hashmaps required char to word and word to char as both will have same content right ?


// ChatGPT said:
// Great question — and it's a very common one when learning about bijections and mappings!

// At first glance, it seems like one Map (e.g., from char -> word) would be enough. But let me explain why both maps are necessary, using a key idea: we need to ensure that the mapping is bijective, meaning:

// \U0001f501 Every character maps to exactly one unique word, and every word maps to exactly one unique character.

// \U0001f504 Why One Map Is NOT Enough
// Imagine we only use a Map<Character, String> (i.e., charToWord), and we check that every character maps consistently to a word.

// Let’s try this input:

// pattern = "ab"

// s = "dog dog"

// What happens?

// a → dog (first time, so map it)

// b → dog (again, it's fine in charToWord, since b hasn't been used yet)

// But now:

// a and b both map to "dog" — not allowed because that breaks the one-to-one rule (two letters map to the same word).

// Using only charToWord, this input would wrongly return true.

// ✅ Why We Need Both Maps
// To fix that, we also need wordToChar:

// When we process the word "dog" for the second time (now with b), we check:

// Is "dog" already mapped to some letter? Yes, it’s mapped to a.

// But now you're trying to map it to b → ❌ mismatch → return false.

// This second map catches conflicts from the reverse direction that the first map can’t detect alone.

