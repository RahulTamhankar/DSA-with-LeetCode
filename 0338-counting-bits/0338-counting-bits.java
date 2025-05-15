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

// What does this line mean?
// java
// Copy
// Edit
// ans[i] = ans[i >> 1] + (i & 1);
// Let’s break it:

// i >> 1 means divide i by 2 (ignore remainder).
// → This helps us reuse an answer we already know.

// i & 1 checks if the number is odd (adds 1 if the last bit is 1).

// So we say:

// "The number of 1s in i is the same as i/2, plus 1 if i is odd."

// \U0001f522 Step-by-step when n = 5
// Let's go through it line by line:

// Start:
// java
// Copy
// Edit
// ans = [0, 0, 0, 0, 0, 0]
// Loop:
// i = 1:
// ans[1] = ans[0] + 1 = 0 + 1 = 1
// → binary of 1 is 1 → 1 one

// i = 2:
// ans[2] = ans[1] + 0 = 1 + 0 = 1
// → binary of 2 is 10 → 1 one

// i = 3:
// ans[3] = ans[1] + 1 = 1 + 1 = 2
// → binary of 3 is 11 → 2 ones

// i = 4:
// ans[4] = ans[2] + 0 = 1 + 0 = 1
// → binary of 4 is 100 → 1 one

// i = 5:
// ans[5] = ans[2] + 1 = 1 + 1 = 2
// → binary of 5 is 101 → 2 ones

// ✅ Final result:
// java
// Copy
// Edit
// ans = [0, 1, 1, 2, 1, 2]
// TL;DR (in very simple words):
// You're counting the 1s in binary of each number from 0 to n, using smart reuse of previous answers.

