class Solution {
    public int findComplement(int num) {
        int mask=1;
        while(mask<num){
            mask=(mask<<1) | 1;
        }
        return num ^ mask;
    }
}

// If num = 5 (binary 101):

// Loop iterations:

// mask = 1 → 001

// mask = (1 << 1) | 1 = 3 → 011

// mask = (3 << 1) | 1 = 7 → 111 (now mask >= num, so we stop)

// java
// Copy
// Edit
//         return num ^ mask;
// Finally, you return the XOR (^) of num and mask.