class Solution {
    public int longestPalindrome(String s) {
        int freq[]=new int[256];
        for(int c:s.toCharArray()){
            freq[c]++;
        }
        int palinLen=0;
        boolean oddFreqExist=false;
        for(int fr:freq){
            if(fr%2!=0){
                oddFreqExist=true;
            }
            palinLen+=(fr/2);  // eg suppose fr is 5 then
            //5/2=2, __even__[odd]__even__ , so 2 pairs, 
        }
        return (palinLen*2+((oddFreqExist)?1:0));//to get actual length * it by 2,and if odd exists add+1
    }
}

//even var for(var fr:freq){ will work

// Explanation
// When using var, Java infers the type from the collection being iterated:
// If you're doing:

// java
// Copy
// Edit
// for (var c : s.toCharArray())
// Java sees you're iterating over a char[], so it treats var as char.

// If you're doing:

// java
// Copy
// Edit
// for (var fr : freq)
// Java sees you're iterating over an int[], so it treats var as int.

// This is why both of these work:

// java
// Copy
// Edit
// for (var c : s.toCharArray()) {  // var → char
//     freq[c]++;
// }

// for (var fr : freq) {            // var → int
//     ...
// }
// And why this fails:

// java
// Copy
// Edit
// for (char fr : freq) // ❌ freq is int[], char is too small — narrowing not allowed