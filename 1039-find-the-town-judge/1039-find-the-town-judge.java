class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];  // how many trust i
        int[] out = new int[n + 1]; // how many i trusts

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            out[a]++;  // a trusts someone → can't be judge
            in[b]++;   // b is trusted by someone
        }

        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0)
                return i; // found judge
        }

        return -1; // no judge
    }
}


// Why N - 1?
// In a town of N people:
// The town judge is trusted by everyone else.
// That means all other N - 1 people trust the judge.

//OR
// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         int[] trustScore = new int[n + 1];

//         for (int[] t : trust) {
//             trustScore[t[0]]--; // loses score for trusting someone
//             trustScore[t[1]]++; // gains score for being trusted
//         }

//         for (int i = 1; i <= n; i++) {
//             if (trustScore[i] == n - 1)
//                 return i; // judge found
//         }

//         return -1;
//     }
// }

// n = 3, trust = [[1,3],[2,3]]
// → 1 → 3
// → 2 → 3
// → 3 is trusted by 2, and trusts no one
// ✅ Output: 3
