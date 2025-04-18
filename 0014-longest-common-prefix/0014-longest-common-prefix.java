// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         Arrays.sort(strs);
//         String s1=strs[0];
//         String s2=strs[strs.length-1];
//         int idx=0;
//         while(idx<s1.length() && idx<s2.length()){
//             if(s1.charAt(idx)==s2.charAt(idx)){
//                 idx++;
//             }else{
//                 break;
//             }
//         }
//         return s1.substring(0,idx);
//     }
// }

// \U0001f914 But why check s2.length()?
// Even though s1 is the first string in the sorted array and s2 is the last string, s2 can be shorter than s1.

// ⚠️ Let’s look at an example:
// Input:

// java
// Copy
// Edit
// ["zebra", "zip"]
// After sorting:

// java
// Copy
// Edit
// ["zebra", "zip"]
// Now:

// s1 = "zebra"

// s2 = "zip"

// So:

// s1.length() = 5

// s2.length() = 3

// Now imagine your loop was:

// java
// Copy
// Edit
// while (idx < s1.length())
// Then when idx = 3, you'd try to access s2.charAt(3), which doesn't exist → \U0001f4a5 StringIndexOutOfBoundsException

// ✅ So the correct and safe way is:
// java
// Copy
// Edit
// while(idx < s1.length() && idx < s2.length())
// Because it ensures you're not reading past the end of either string while comparing characters.

//-------------------------------------
//Horizontal Scanning
// class Solution{
//     public String longestCommonPrefix(String[] strs) {
//         String prefix=strs[0];
//         for(int i=1;i<strs.length;i++){
//             while(!strs[i].startsWith(prefix)){
//                 prefix=prefix.substring(0,prefix.length()-1);
//                 if(prefix.isEmpty()) return "";
//             }
//         }
//         return prefix;
//     }
// }
//-------------------------------------
//Binary Search
class Solution{
    public String longestCommonPrefix(String[] strs) {
       int high=strs[0].length();
       for(int i=0;i<strs.length;i++){
        high=Math.min(high,strs[i].length());
       }
        int low=1;
        String prefix="";
        while(low<=high){
            int mid=(low+high)/2;

            if(isCommonPrefix(strs,mid)){
                prefix=strs[0].substring(0,mid);
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return prefix;
    }

    private boolean isCommonPrefix(String[] strs,int len){
        String prefix=strs[0].substring(0,len);
        for(int i=1;i<strs.length;i++){
            if(!strs[i].startsWith(prefix)){
//                 For each string, check if it starts with the prefix we selected.If any string doesn't match, then this prefix is not common, so we return false immediately
                return false;
            }
        }
        return true;
    }
}


// String[] strs = {"flower", "flow", "flight"};
// len = 2

// prefix = "fl"

// Check:
// - "flow".startsWith("fl") ✅
// - "flight".startsWith("fl") ✅

// All match → return `true`

//-------------------------------------------
//Recursion
// class Solution {
    
//     public String getPrefix(String prevStr, int idx, String strs[]) {
//         if(idx == strs.length) {
//             return prevStr;
//         }
        
//         String currStr;
//         StringBuilder newStr = new StringBuilder("");
//         currStr = strs[idx];
//         int sStr = prevStr.length() < currStr.length() ? prevStr.length() : currStr.length();
        
//         for(int i=0; i<sStr; i++) {
//             if(currStr.charAt(i) == prevStr.charAt(i)) {
//                 newStr.append(currStr.charAt(i));
//             } 
//             else {
//                 break;
//             }
//         }
        
//         return getPrefix(newStr.toString(), idx+1, strs);
        
//     }
    
//     public String longestCommonPrefix(String[] strs) {
        
//         return getPrefix(strs[0], 1, strs);
//     }
// }

//  What this code is doing:
// You're recursively comparing one string at a time with the current prefix, and narrowing down that prefix until it's common across all strings.

// \U0001f4e6 Example Input:
// java
// Copy
// Edit
// String[] strs = {"flower", "flow", "flight"};
// \U0001f4a1 Method Entry Point:
// java
// Copy
// Edit
// longestCommonPrefix(strs)
// // calls: getPrefix("flower", 1, strs)
// \U0001f501 Let's Walk Through Recursion
// \U0001f539 Call 1:
// java
// Copy
// Edit
// getPrefix("flower", 1, strs)
// Compare "flower" and "flow"

// Shorter string length: 4

// Compare characters:

// 'f' == 'f' ✅

// 'l' == 'l' ✅

// 'o' == 'o' ✅

// 'w' == 'w' ✅
// ➡️ newStr = "flow"

// Now it calls:

// java
// Copy
// Edit
// getPrefix("flow", 2, strs)
// \U0001f539 Call 2:
// java
// Copy
// Edit
// getPrefix("flow", 2, strs)
// Compare "flow" and "flight"

// Shorter string length: 4

// Compare characters:

// 'f' == 'f' ✅

// 'l' == 'l' ✅

// 'o' != 'i' ❌
// ➡️ newStr = "fl"

// Now it calls:

// java
// Copy
// Edit
// getPrefix("fl", 3, strs)
// \U0001f539 Call 3:
// java
// Copy
// Edit
// getPrefix("fl", 3, strs)
// Base case: idx == strs.length (3 == 3) ➡️ Return "fl"

// ✅ Final Answer:
// java
// Copy
// Edit
// "fl"
// \U0001f504 Visualization Tree:
// scss
// Copy
// Edit
// getPrefix("flower", 1)
//    ↓
// getPrefix("flow", 2)
//    ↓
// getPrefix("fl", 3) → returns "fl"
// Each step reduces the prefix based on comparison with the next string.