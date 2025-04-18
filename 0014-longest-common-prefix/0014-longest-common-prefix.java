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
                return false;
            }
        }
        return true;
    }
}