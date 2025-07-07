// class Solution {
//     public int longestValidParentheses(String s) {
       
//         int left=0;
//         int right=0;
//         int max=0;
        
//         for(int i=0;i<s.length();i++)
//         {
//             if (s.charAt(i)=='(')
//                 left++;
//             else
//                 right++;
//             if(left==right)
//             {
//                 max=Math.max(max,left*2);
//             }else if(right>left)
//             {
//                 left=0;
//                 right=0;
//             }
//         }
        
//         left=0;
//         right=0;
        
//         for(int i=s.length()-1;i>=0;i--)
//         {
//             if (s.charAt(i)=='(')
//                 left++;
//             else
//                 right++;
//             if(left==right)
//             {
//                 max=Math.max(max,left*2);
//             }else if(left>right)
//             {
//                 left=0;
//                 right=0;
//             }
//         }
      
//         return max;
        
        
//     }
// }

// "(()())"

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base index for valid substrings
        
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // Reset base index to current
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
}



// | i | s.charAt(i) | Stack before | Action           | Stack after | maxLen       |
// | - | ----------- | ------------ | ---------------- | ----------- | ------------ |
// | - | -           | **\[-1]**    | Init             | **\[-1]**   | 0            |
// | 0 | `(`         | \[-1]        | Push 0           | \[-1, 0]    | 0            |
// | 1 | `(`         | \[-1, 0]     | Push 1           | \[-1, 0, 1] | 0            |
// | 2 | `)`         | \[-1, 0, 1]  | Pop → \[ -1, 0 ] | \[ -1, 0 ]  | 2 (2 - 0)    |
// | 3 | `(`         | \[-1, 0]     | Push 3           | \[-1, 0, 3] | 2            |
// | 4 | `)`         | \[-1, 0, 3]  | Pop → \[-1, 0]   | \[-1, 0]    | 4 (4 - 0)    |
// | 5 | `)`         | \[-1, 0]     | Pop → \[-1]      | \[-1]       | 6 (5 - (-1)) |
