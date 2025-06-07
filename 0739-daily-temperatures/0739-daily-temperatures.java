// //T.C : O(n)
// //S.C :O(n)
// public class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
//         Stack<Integer> st = new Stack<>();
        
//         int[] result = new int[n];
        
//         for (int i = n - 1; i >= 0; i--) {
//             while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
//                 st.pop();
//             }
            
//             if (st.isEmpty()) {
//                 result[i] = 0;
//             } else {
//                 result[i] = st.peek() - i; // days
//             }
            
//             st.push(i);
//         }
        
//         return result;
//     }
// }


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int hottest = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (temperatures[i] >= hottest) {
                hottest = temperatures[i];
            } else {
                int it = i + 1;
                while (temperatures[it] <= temperatures[i]) {
                    it = it + ans[it];
                }
                ans[i] = it - i;
            }
        }

        return ans;
    }
}

