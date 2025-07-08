
// //Approach-1 (Using simple backtracking)
// //T.C : O(2^n)
// //S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)
// public class Solution {
//     private List<String> result;
//     private Set<String> dict;

//     private void solve(int i, String currSentence, String s) {
//         if (i >= s.length()) {
//             result.add(currSentence.trim());
//             return;
//         }

//         for (int j = i; j < s.length(); j++) {
//             String tempWord = s.substring(i, j + 1);

//             if (dict.contains(tempWord)) {
//                 String originalSentence = currSentence;
//                 if (!currSentence.isEmpty()) {
//                     currSentence += " ";
//                 }
//                 currSentence += tempWord;

//                 solve(j + 1, currSentence, s);

//                 currSentence = originalSentence;
//             }
//         }
//     }

//     public List<String> wordBreak(String s, List<String> wordDict) {
//         result = new ArrayList<>();
//         dict = new HashSet<>(wordDict);

//         String currSentence = "";
//         solve(0, currSentence, s);

//         return result;
//     }
// }


//Approach-2 (Using simple backtracking)
//T.C : O(2^n)
//S.C : max depth of recursion is n (length of string s). You can say O(n) . You also have to store those sentences which is O(2^n)
public class Solution {
    private Set<String> dict;
    private Map<String, List<String>> memo;

    private List<String> solve(String s) {
        if (s.isEmpty()) {
            return Arrays.asList("");
        }
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        for (int l = 1; l <= s.length(); l++) {
            String currWord = s.substring(0, l);
            if (dict.contains(currWord)) {
                String remainWord = s.substring(l);
                List<String> remainResult = solve(remainWord);
                for (String w : remainResult) {
                    String toAdd = currWord + (w.isEmpty() ? "" : " ") + w;
                    result.add(toAdd);
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        memo = new HashMap<>();

        return solve(s);
    }
}