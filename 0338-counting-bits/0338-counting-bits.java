class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];

        for(int i=1;i<=n;i++){
            ans[i]=ans[i>>1]+(i&1);
        }
        return ans;
    }
}

// When you do i >> 1, you're chopping off the last bit (the rightmost bit).
// That last bit could be a 0 or a 1 — but you’re throwing it away in the shift.
// So...
// \U0001f449 If the bit you removed was 1, then you just lost a 1 in the binary representation.
// \U0001f449 So you need to add it back, and that’s exactly why we do (i & 1)