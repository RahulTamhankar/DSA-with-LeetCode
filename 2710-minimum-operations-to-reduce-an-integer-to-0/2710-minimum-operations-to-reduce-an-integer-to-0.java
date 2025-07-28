class Solution {
    public int minOperations(int n) {
        if((n&(n-1))==0){
            return 1;
        }

        int low=1<<(int) (Math.log(n)/Math.log(2));

        int high=low<<1;

        int d1=n-low;
        int d2=high-n;

        return 1+Math.min(minOperations(d1),minOperations(d2));
    }
}