// class Solution {
//     int n;
//     int[][] memo;

//     public int solve(String s, int currIndex, int prevVal) {
//         if (currIndex >= n)
//             return 0;

//         if (memo[currIndex][prevVal] != -1)
//             return memo[currIndex][prevVal];

//         int flip = Integer.MAX_VALUE;
//         int noFlip = Integer.MAX_VALUE;

//         char currentChar = s.charAt(currIndex);

//         if (currentChar == '0') {
//             if (prevVal == 1) {
//                 flip = 1 + solve(s, currIndex + 1, 1);
//             } else {
//                 flip = 1 + solve(s, currIndex + 1, 1);
//                 noFlip = solve(s, currIndex + 1, 0);
//             }
//         } else { // currentChar == '1'
//             if (prevVal == 1) {
//                 noFlip = solve(s, currIndex + 1, 1);
//             } else {
//                 flip = 1 + solve(s, currIndex + 1, 0);
//                 noFlip = solve(s, currIndex + 1, 1);
//             }
//         }

//         return memo[currIndex][prevVal] = Math.min(flip, noFlip);
//     }

//     public int minFlipsMonoIncr(String s) {
//         n = s.length();
//         memo = new int[n + 1][2];

//         for (int i = 0; i <= n; i++) {
//             Arrays.fill(memo[i], -1);
//         }

//         return solve(s, 0, 0);
//     }
// }


class Solution {
    public int minFlipsMonoIncr(String s) {
        int countOfOnes = 0;
        int flips = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                countOfOnes++;
            } else {
                flips = Math.min(flips + 1, countOfOnes);
            }
        }

        return flips;
    }
}
