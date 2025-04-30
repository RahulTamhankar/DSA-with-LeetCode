class Solution {
    public int hammingDistance(int x, int y) {
        int xor=x^y;
        int distance=0;
        while(xor!=0){
            distance+=xor&1;
            xor>>=1;
        }
        return distance;
    }
}

// \U0001f914 What is & 1?
// This operation checks whether the last bit (rightmost bit) of a binary number is 1 or 0.

// Example:

// Let's say the number is 5 → binary: 0101

// Now do:

// java
// Copy
// Edit
// 5 & 1
// 0101 (which is 5)

// 0001 (this is the binary for 1)

// Bitwise AND means:

// 0 & 0 → 0

// 1 & 0 → 0

// 0 & 1 → 0

// 1 & 1 → 1

// So:

// markdown
// Copy
// Edit
//   0101
// & 0001
// -------
//   0001  → result is 1
// This tells us: the last bit is 1. So, we increase our count.

// \U0001f501 What is >>= 1?
// This shifts all bits one position to the right, dropping the last bit.

// Example: Start with 5 → 0101
// Now do:

// java
// Copy
// Edit
// xor >>= 1;
// → 0101 becomes 0010 (which is 2)

// It’s like cutting off the last bit and shifting all others one place to the right.

// \U0001f504 Full step-by-step:
// Let’s walk through the code with x = 1 and y = 4 again.

// java
// Copy
// Edit
// int x = 1;  // binary: 0001
// int y = 4;  // binary: 0100

// int xor = x ^ y;  // xor = 5 = binary 0101
// int distance = 0;
// Now we do this loop:

// java
// Copy
// Edit
// while (xor != 0) {
//     distance += xor & 1;  // Check if last bit is 1
//     xor >>= 1;            // Shift right to process next bit
// }

// Step	xor (binary)	xor & 1	Add to distance?	Distance	xor after >>= 1
// 1	0101 (5)	1	Yes	1	0010 (2)
// 2	0010 (2)	0	No	1	0001 (1)
// 3	0001 (1)	1	Yes	2	0000 (0)
// Now xor = 0, so loop ends. Final Hamming distance = 2.

// \U0001f9e0 Summary:
// & 1 → asks: is the last bit a 1? If yes, add 1 to count.

// >>= 1 → shifts the number to the right, so we check the next bit in the next loop.

// We keep doing this until all bits are checked.