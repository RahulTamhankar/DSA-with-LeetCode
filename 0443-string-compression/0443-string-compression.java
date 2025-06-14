class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int i=0;
        int index=0;

        while(i<n){
            char curr=chars[i];

            int count=0;

            while(i<n && chars[i]==curr){
                i++;
                count++;
            }

            chars[index++]=curr;

            if(count>1){   // if {a,b} then we dont write a1b1. Only write when 2 3.. etc if its 10 then a10b1->5

            String countStr=Integer.toString(count);
            for(char ch:countStr.toCharArray()){
                chars[index++]=ch;
            }

            }
        }
        return index;
    }
}