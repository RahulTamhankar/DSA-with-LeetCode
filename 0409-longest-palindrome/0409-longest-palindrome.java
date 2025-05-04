class Solution {
    public int longestPalindrome(String s) {
        int freq[]=new int[256];
        for(var c:s.toCharArray()){
            freq[c]++;
        }
        int palinLen=0;
        boolean oddFreqExist=false;
        for(var fr:freq){
            if(fr%2!=0){
                oddFreqExist=true;
            }
            palinLen+=(fr/2);  // eg suppose fr is 5 then
            //5/2=2, __even__[odd]__even__ , so 2 pairs, 
        }
        return (palinLen*2+((oddFreqExist)?1:0));//to get actual length * it by 2,and if odd exists add+1
    }
}