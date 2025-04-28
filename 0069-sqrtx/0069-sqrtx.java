class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }

        int start=1;
        int end=x;
        int mid=-1;

        while(start<=end){
            mid=start+(end-start)/2;
            if((long)mid*mid>(long)x){
                end=mid-1;
            }else if(mid*mid==x){
                return mid;
            }else{
                start=mid+1;
            }
        }
        return Math.round(end);
    }
}

// You can remove (long) if you know that mid * mid will never get too big for int type.

// But sometimes, if x is a very big number (like close to 2,000,000,000), then:

// mid could be large (example: around 46,000),

// and mid * mid becomes a huge number — bigger than what an int can hold,

// so mid * mid can overflow and give a wrong answer.