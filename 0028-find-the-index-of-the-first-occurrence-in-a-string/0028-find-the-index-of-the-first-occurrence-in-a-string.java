class Solution {
    public int strStr(String haystack, String needle) {
        int l=haystack.length(),k=needle.length();
        int i=0,j=0;
        while(j<l){
            if(j-i+1<k){
                j++;
            }else{
                if(haystack.substring(i,j+1).equals(needle)){
                    return i;
                }
                i++;
                j++;
            }
        }
        return -1;
    }
}