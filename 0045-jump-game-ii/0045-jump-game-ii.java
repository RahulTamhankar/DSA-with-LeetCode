// class Solution {
//     public int jump(int[] nums) {
//         int totalJumps=0;
//         int destination=nums.length-1;
//         int coverage=0,lastJumpIdx=0;

//         if(nums.length==1) return 0;

//         for(int i=0;i<nums.length;i++){
//             coverage=Math.max(coverage,i+nums[i]);

//             if(i==lastJumpIdx){
//                 lastJumpIdx=coverage;
//                 totalJumps++;

//                 if(coverage>=destination){
//                     return totalJumps;
//                 }
//             }
//         }
//         return totalJumps;
//     }
// }

//DPO(N^2)
class Solution {

    public int jump(int[] nums) {
        int i,n,j;
        n=nums.length;
        int [] pre = new int[n];
        for(i=0;i<n;i++)
        {
            // Initialize all the index position with some max value to denote it is unreachable
            pre[i] = Integer.MAX_VALUE;
        }
        
        // Make the first position value as 0 as it is the default place where we start
        pre[0] = 0;
		// Main condition check goes here.
        for(i=0;i<n;i++)
        {
            for(j=i;j<=i+nums[i] && j<n;j++)
            {
                pre[j] = Math.min(pre[j], pre[i]+1);
            }
        }
        return pre[n-1];
    }
}

// Breaking down the condition:
// java
// Copy
// Edit
// for(j = i; j <= i + nums[i] && j < n; j++)
// j = i: Start from the current index i.

// j <= i + nums[i]: You can jump from i to any index up to i + nums[i] — that's your maximum reachable index from i.

// j < n: Make sure you stay within bounds of the array.

// So, this inner loop explores all reachable positions j from index i.

// \U0001f9ea Example:
// java
// Copy
// Edit
// nums = [2, 3, 1, 1, 4]
// You can jump at most nums[i] steps from index i.

// You want the minimum number of jumps to reach the end (index 4).

// \U0001f6a6 Initialization:
// java
// Copy
// Edit
// int[] pre = new int[5]; // length of nums = 5
// pre = [0, ∞, ∞, ∞, ∞] // ∞ is Integer.MAX_VALUE
// pre[0] = 0 because you're starting there.

// The rest are initially unreachable.

// \U0001f501 Processing:
// At i = 0 (nums[0] = 2)
// You can go to j = 1 and 2.

// java
// Copy
// Edit
// pre[1] = min(∞, 0 + 1) = 1
// pre[2] = min(∞, 0 + 1) = 1
// pre = [0, 1, 1, ∞, ∞]

// At i = 1 (nums[1] = 3)
// You can go to j = 2, 3, 4.

// java
// Copy
// Edit
// pre[2] = min(1, 1 + 1) = 1
// pre[3] = min(∞, 1 + 1) = 2
// pre[4] = min(∞, 1 + 1) = 2
// pre = [0, 1, 1, 2, 2]

// At i = 2 (nums[2] = 1)
// Can go to j = 3

// java
// Copy
// Edit
// pre[3] = min(2, 1 + 1) = 2
// pre = [0, 1, 1, 2, 2] (no change)

// At i = 3 (nums[3] = 1)
// Can go to j = 4

// java
// Copy
// Edit
// pre[4] = min(2, 2 + 1) = 2
// Still pre = [0, 1, 1, 2, 2]

// ✅ Final pre[]:
// csharp
// Copy
// Edit
// [0, 1, 1, 2, 2]
// \U0001f51a Meaning:
// pre[i] = minimum number of jumps needed to reach index i

// So to reach the end (index 4), it takes pre[4] = 2 jumps.

// What are we carrying in the dpa array?


// ChatGPT said:
// Great question.

// In your jump problem's DP array (pre[]), you're carrying:

// \U0001f9e0 What is stored in pre[i]?
// pre[i] represents the minimum number of jumps required to reach index i from the start (index 0).

// \U0001f50d Example Trace:
// Suppose nums = [2, 3, 1, 1, 4]

// We want to fill pre[] like this:

// java
// Copy
// Edit
// pre[0] = 0 // no jumps needed to be at index 0
// pre[1] = 1 // can be reached in 1 jump from 0
// pre[2] = 1 // also reachable in 1 jump from 0
// pre[3] = 2 // reached by jumping from 1
// pre[4] = 2 // reached by jumping from 1
// So, the final pre[] would be:

// java
// Copy
// Edit
// pre = [0, 1, 1, 2, 2]
// \U0001f4a1 Purpose: