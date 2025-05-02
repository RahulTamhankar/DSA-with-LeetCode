public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n==0) return 0;
        int result=0;
        for(int i=0;i<32;i++){
            result<<=1;
            if((n&1)==1) result++;
            n>>=1;
        }
    return result;
    }
}

// \U0001f3af Goal:
// Given a 32-bit integer, reverse the order of its bits.

// For example, if n = 5:

// Binary of n: 00000000000000000000000000000101

// Reversed bits: 10100000000000000000000000000000 → which is 2684354560

// You're not reversing the digits (like strings), you're reversing bit positions.

// \U0001f9e0 Intuition Behind the Code:
// Think of the binary number as a row of lights (bits) that can be ON (1) or OFF (0):

// less
// Copy
// Edit
// Original bits:  [0][0][0]...[0][1][0][1]
// Bit index:        31       ...   2  1  0
// You want to flip the entire row, so that bit at index 0 goes to 31, 1 to 30, and so on.

// \U0001f504 How the Loop Helps:
// You build a new number, result, starting from 0. At each step:

// Shift result left by 1 → Make room for the next bit.

// Get the current last bit of n → (n & 1)

// Put that bit into result’s last position (via result++)

// Shift n right to move to the next bit.

// You do this 32 times (because it’s a 32-bit number), and in doing so, you’re placing each bit of n into the mirror position in result.

// \U0001f527 Analogy:
// Imagine you're reading a string backwards and building a new one forwards:

// Read n right to left → n >>= 1

// Build result left to right → result <<= 1