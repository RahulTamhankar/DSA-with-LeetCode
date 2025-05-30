class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

    // Check for empty inputs
    if (strs == null || strs.length == 0)
      return new ArrayList<>();

    Map<String, List<String>> frequencyStringsMap = new HashMap<>();
    for (String str : strs) {

      String frequencyString = getFrequencyString(str);

      // If the frequency string is present, add the string to the list
      if (frequencyStringsMap.containsKey(frequencyString)) {
        frequencyStringsMap.get(frequencyString).add(str);
      }
      else {
        // else create a new list
        List<String> strList = new ArrayList<>();
        strList.add(str);
        frequencyStringsMap.put(frequencyString, strList);
      }
    }

    return new ArrayList<>(frequencyStringsMap.values());
  }

  private String getFrequencyString(String str) {

    // Frequency buckets
    int[] freq = new int[26];

    // Iterate over each character
    for (char c : str.toCharArray()) {
      freq[c - 'a']++;              // for the word "eat", freq = [1, 0, 0, 0, 1, 0, 0, ..., 1, ..., 0];  // length 26

    }
    //and frequencyString will look like a1b0c0d0e1f0g0h0i0j0k0l0m0n0o0p0q0r0s0t1u0v0w0x0y0z0


    // Start creating the frequency string
    StringBuilder frequencyString = new StringBuilder("");
    char c = 'a';
    for (int i : freq) {
      frequencyString.append(c);
      frequencyString.append(i);
      c++;
    }

    return frequencyString.toString();
  }
}









// public List<List<String>> groupAnagramsCategorizeBySorting(String[] strs) {

//     if (strs == null || strs.length == 0)
//       return new ArrayList<>();

//     Map<String, List<String>> stringAnagramsMap = new HashMap<>();
//     for (String s : strs) {
//       char[] arr = s.toCharArray();
//       Arrays.sort(arr);
//       String key = String.valueOf(arr);

//       if (!stringAnagramsMap.containsKey(key))
//         stringAnagramsMap.put(key, new ArrayList<>());

//       stringAnagramsMap.get(key).add(s);
//     }

//     List<List<String>> resultList = new ArrayList<>();
//     for (Map.Entry<String, List<String>> stringAnagrams : stringAnagramsMap.entrySet()) {
//       resultList.add(stringAnagrams.getValue());
//     }
//     return resultList;
//   }

//---------------CodewMie
// //Approach-1 (Using Sorting)
// //T.C : O(n*klog(k))  (n = size of input, k = maximum length of a string in the input vector)
// //S.C : O(n*k)
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();

//         for (String str : strs) {
//             char[] charArray = str.toCharArray();
//             Arrays.sort(charArray);
//             String sortedStr = new String(charArray);

//             if (!map.containsKey(sortedStr)) {
//                 map.put(sortedStr, new ArrayList<>());
//             }

//             map.get(sortedStr).add(str);
//         }

//         return new ArrayList<>(map.values());
//     }
// }


// //Approach-2
// //T.C : O(n*k)  (n = size of input, k = maximum length of a string in the input vector)
// //S.C : O(n*k)
// class Solution {
//     private String generate(String s) {
//         int[] count = new int[26];

//         for (char ch : s.toCharArray()) {
//             count[ch - 'a']++;
//         }

//         StringBuilder newS = new StringBuilder();

//         for (int i = 0; i < 26; i++) {
//             if (count[i] > 0) {
//                 newS.append(String.valueOf((char) (i + 'a')).repeat(count[i]));
//             }
//         }

//         return newS.toString();
//     }

//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();

//         for (String s : strs) {
//             String newS = generate(s);

//             if (!map.containsKey(newS)) {
//                 map.put(newS, new ArrayList<>());
//             }

//             map.get(newS).add(s);
//         }

//         return new ArrayList<>(map.values());
//     }
// }