import java.util.*;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int m = n - 1;
        List<Integer> pairSum = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            pairSum.add(weights[i] + weights[i + 1]);
        }

        Collections.sort(pairSum);

        long maxSum = 0;
        long minSum = 0;

        for (int i = 0; i < k - 1; i++) {
            minSum += pairSum.get(i);
            maxSum += pairSum.get(m - 1 - i);
        }

        return maxSum - minSum;
    }
}

    
// dry run why             m-1-i); 
// ChatGPT said:
// Great question! Let's dry run and explain why the expression m - 1 - i is used in this line:

// java
// Copy
// Edit
// maxSum += pairSum.get(m - 1 - i);
// Context Recap:
// We are given an array of weights and need to split it into k groups such that we maximize and minimize the sum of adjacent pair weights (i.e., weights[i] + weights[i+1]). Then we return the difference between the maximum and minimum total.

// Step-by-Step Dry Run
// Suppose:
// java
// Copy
// Edit
// weights = [1, 3, 5, 1]
// k = 2
// Step 1: Compute pair sums
// From weights[i] + weights[i+1], we get:

// 1 + 3 = 4

// 3 + 5 = 8

// 5 + 1 = 6

// So, pairSum = [4, 8, 6]
// Here, n = 4, so m = n - 1 = 3

// Step 2: Sort pairSum
// After sorting: pairSum = [4, 6, 8]

// Step 3: Loop for k - 1 = 1 (since k = 2)
// java
// Copy
// Edit
// minSum += pairSum.get(i);        // i = 0 → minSum += 4
// maxSum += pairSum.get(m - 1 - i); // m = 3 → maxSum += pairSum.get(3 - 1 - 0) = pairSum.get(2) = 8
// So:

// minSum = 4

// maxSum = 8

// return maxSum - minSum = 8 - 4 = 4

// Why m - 1 - i?
// We need the largest (k - 1) values from pairSum for maxSum, and the smallest (k - 1) for minSum.

// Since pairSum is sorted in ascending order:

// The smallest are at the start → pairSum.get(i)

// The largest are at the end → pairSum.get(m - 1 - i)

// Using m - 1 - i lets us:

// Start at the last element (m - 1) and move backward as i increases.

// Example: i = 0 → m - 1 - 0 = 2 (last element)

// So we get the top (largest) k - 1 pair sums for maxSum.

// Summary
// The m - 1 - i expression is used to pick the largest values from the end of the sorted pairSum list, which is essential for computing the maximum possible sum of selected adjacent pairs.

// so if its just a way to select the last index why not m-1 why again -i


// ChatGPT said:
// Awesome follow-up — you're exactly right to question this. Let's clarify the reason for m - 1 - i instead of just m - 1.

// Short Answer:
// Because we need to pick the top k - 1 largest values, not just one value.

// Why Not Just m - 1?
// m - 1 gets you only the last element.

// But we need to get the last (k - 1) elements, one by one.

// So, we loop i from 0 to k - 2:

// When i = 0: we get m - 1 - 0 → last element

// When i = 1: we get m - 1 - 1 → second last

// When i = 2: we get m - 1 - 2 → third last

// ...

// This pattern selects the largest values from the sorted array starting from the end and moving backward.

// Visual Example
// Let’s say pairSum = [2, 5, 8, 10, 13] (sorted), so m = 5

// If k = 3, we need k - 1 = 2 top values for maxSum.

// Using the loop:

// java
// Copy
// Edit
// for (int i = 0; i < k - 1; i++) {
//     maxSum += pairSum.get(m - 1 - i);
// }
// We get:

// i = 0 → pairSum[4] = 13

// i = 1 → pairSum[3] = 10

// So maxSum = 13 + 10 = 23

// So Why m - 1 - i?
// It’s a moving index from the last element backward:

// m - 1 gives the last index

// - i allows us to go further back as the loop progresses

// Final Thought:
// If you only did m - 1, you’d get only one value every time — not a looped selection of the top k - 1 values.

// So m - 1 - i is critical for stepping backward through the top elements.




