class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in=new int[n+1];
        int[] out=new int[n+1];
        for(int[] a:trust){
            out[a[0]]++;
            in[a[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(in[i]==n-1 && out[i]==0)
                return i;
        }
        return -1;
    }
}

// Why N - 1?
// In a town of N people:
// The town judge is trusted by everyone else.
// That means all other N - 1 people trust the judge.

//OR
// public class Solution {
//     public int findJudge(int n, int[][] trust) {
//         int[] trustScore = new int[n + 1];

//         for (int[] t : trust) {
//             trustScore[t[0]]--; // person trusts someone
//             trustScore[t[1]]++; // person is trusted by someone
//         }

//         for (int i = 1; i <= n; i++) {
//             if (trustScore[i] == n - 1) {
//                 return i; // found the judge
//             }
//         }

//         return -1; // no judge found
//     }
// }
