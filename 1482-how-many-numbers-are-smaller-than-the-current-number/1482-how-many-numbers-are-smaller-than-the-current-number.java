class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] buckets=new int[102];
        for(int num:nums){
            buckets[num]++;
        }

        //This converts buckets[i] to prefix sum: number of elements ≤ i.
        for(int i=1;i<buckets.length;i++){
            buckets[i]+=buckets[i-1];
        }

        int[] result=new int[nums.length];
        for(int i=0;i<result.length;i++){
            if(nums[i]==0)
                result[i]=0;
            else
                result[i]=buckets[nums[i]-1];
        }
        return result;
    }
}

// Great question! Let’s break this down simply so you understand why prefix sum is used, how it helps, and why someone would think of it in the first place.

// \U0001f501 The Brute Force Way (Naive Approach)
// Let’s start with the basic idea:

// java
// Copy
// Edit
// for each i in nums:
//     count = 0
//     for each j in nums:
//         if nums[j] < nums[i]:
//             count++
//     result[i] = count
// This works, but it’s O(n²) time. Too slow if nums.length is large (e.g., 10⁴).

// \U0001f914 So What Can We Optimize?
// We only care about how many numbers are smaller than nums[i], not which ones.

// \U0001f4a1 This sounds like a counting problem.

// Now think about the values:

// Each number in nums is between 0 and 100 (as per the problem's constraints).

// So the number range is small. Just 101 possibilities.

// That suggests we can use counting sort techniques.

// \U0001f4e6 Counting Sort Intuition
// Step 1: Frequency Count
// Count how many times each number occurs:

// java
// Copy
// Edit
// int[] count = new int[101];
// for (int num : nums) {
//     count[num]++;
// }
// Example:
// nums = [8,1,2,2,3]
// → count[1] = 1, count[2] = 2, count[3] = 1, count[8] = 1

// But this still only tells us how many times each number appears, not how many numbers are smaller than each number.

// \U0001f522 Prefix Sum = "How many numbers ≤ i?"
// We build prefix sums on the count array:

// java
// Copy
// Edit
// for (int i = 1; i < count.length; i++) {
//     count[i] += count[i - 1];
// }
// Now:

// count[i] tells us how many numbers are ≤ i

// So, count[i - 1] tells us how many numbers are < i

// Why is this powerful?
// Instead of checking all numbers less than nums[i], we now know the answer in O(1) time by looking at count[nums[i] - 1].

// \U0001f50d Let’s Walk It for nums = [8,1,2,2,3]
// Frequencies:
// java
// Copy
// Edit
// count = [0, 1, 2, 1, 0, ..., 0, 1]
// After Prefix Sum:
// java
// Copy
// Edit
// count = [0, 1, 3, 4, 4, ..., 5]
// count[0] = 0 → 0 numbers ≤ 0

// count[1] = 1 → 1 number ≤ 1

// count[2] = 3 → 3 numbers ≤ 2

// count[3] = 4 → 4 numbers ≤ 3

// count[7] = 4 → 4 numbers ≤ 7

// So for nums[i] = 8, count[7] = 4 → 4 numbers less than 8

// \U0001f9e0 Why Would You Think of This?
// It comes with experience doing counting problems with:

// Limited value ranges

// Where you don’t care about indexes/positions

// You want counts like "how many less than me?"

// You realize:

// "Hmm... there are only 0–100 possible values. What if I just count how many times each value shows up, then build a prefix sum?"

// This is a common trick used in:

// Counting sort

// Histogram processing

// Bucket sort variants

// Range frequency problems

// ✅ Final Takeaway
// We use prefix sum because it converts frequency data into "how many values are less than x" in O(1) time.

// It drastically improves the time complexity from O(n²) → O(n + k) where k = 101.

// hows that possible explainSo, count[i - 1] tells us how many numbers are < i


// ChatGPT said:
// Absolutely, let me walk you through why count[i - 1] tells us how many numbers are less than i when using prefix sums.

// \U0001f501 Step-by-Step Understanding:
// Let’s say we have an input array:

// java
// Copy
// Edit
// nums = [8, 1, 2, 2, 3]
// We want to know, for each number, how many elements are smaller than it.

// ✅ Step 1: Count Frequencies
// We use a count[] array of size 101 (because nums[i] ∈ [0, 100]):

// java
// Copy
// Edit
// count[1] = 1
// count[2] = 2
// count[3] = 1
// count[8] = 1
// // all other count[i] = 0
// So count[i] tells us how many times the number i appears in nums.

// ✅ Step 2: Prefix Sum
// Now we update the count[] array to make it a prefix sum:

// java
// Copy
// Edit
// for (int i = 1; i < 101; i++) {
//     count[i] += count[i - 1];
// }
// This means:
// count[i] = total number of elements ≤ i

// Let’s walk this prefix sum step through the first few numbers:

// i	count[i] before	count[i] after
// 0	0	0
// 1	1	1
// 2	2	1 + 2 = 3
// 3	1	3 + 1 = 4
// 4	0	4 + 0 = 4
// 8	1	... eventually becomes 5

// So, after this step:

// java
// Copy
// Edit
// count[0] = 0      // 0 elements ≤ 0
// count[1] = 1      // 1 element ≤ 1
// count[2] = 3      // 3 elements ≤ 2 (1, 2, 2)
// count[3] = 4      // 4 elements ≤ 3 (1, 2, 2, 3)
// count[8] = 5      // all 5 elements ≤ 8
// \U0001f525 Now the Key Insight:
// When you want to know:

// “How many numbers are strictly less than x?”

// You look at:

// java
// Copy
// Edit
// count[x - 1]
// Why?

// Because:

// count[x] = number of elements ≤ x

// count[x - 1] = number of elements ≤ (x - 1)
// → which is exactly the number of elements < x

// ✅ Example from nums = [8, 1, 2, 2, 3]
// Let’s find the result for each number:

// nums[0] = 8 → count[7] = 4 → 4 numbers < 8
// (1, 2, 2, 3)

// nums[1] = 1 → count[0] = 0 → 0 numbers < 1

// nums[2] = 2 → count[1] = 1 → 1 number < 2
// (1)

// nums[3] = 2 → same as above → 1

// nums[4] = 3 → count[2] = 3 → 3 numbers < 3
// (1, 2, 2)

// \U0001f3af Final Point:
// The prefix sum transforms the array from:

// "how many times each value appears"

// To:

// "how many total values are ≤ i"
// So to get < i, you just look at count[i - 1].

// Let me know if you'd like a visual drawing or table for any specific part!







// You said:
// so prefix sum converts and array  in ascending order indirectinly by doing prefix sum and then we get how many nos less then each no


// ChatGPT said:
// Exactly! \U0001f4a1 You're getting it — here’s a clearer summary of what you're observing:

// ✅ What prefix sum does in this context:
// We don't sort the array directly, but:

// We build a frequency array (count[]) where:

// count[i] = how many times the number i appears in the original array.

// Then we run prefix sum on this array:

// count[i] = count[i] + count[i - 1]

// This gives:
// count[i] = number of elements ≤ i

// \U0001f3af Why it works without sorting:
// We leverage the fact that numbers range from 0 to 100, which lets us "sort" and query information in O(1) time per number via this prefix sum trick.

// \U0001f4ac Then:
// To find how many numbers are strictly less than x,
// just do:

// java
// Copy
// Edit
// count[x - 1]
// That gives the total count of all elements < x — without actually sorting nums!

// \U0001f680 So in short:
// ✅ Prefix sum on frequency array ≈ cumulative knowledge of "how many numbers are smaller than or equal to i"
// ✅ Using count[i - 1] lets us instantly answer "how many numbers are smaller than i"
// ✅ This is possible without sorting, using counting + prefix sum






