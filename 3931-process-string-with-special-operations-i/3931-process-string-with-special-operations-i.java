// class Solution {
//     public String processStr(String s) {
//         StringBuilder res = new StringBuilder();
//         for (char c : s.toCharArray()) {
//             if (c != '*' && c != '#' && c != '%') {
//                 res.append(c);
//             } else if (c == '#') {
//                 res.append(res.toString());
//             } else if (c == '%') {
//                 res.reverse();
//             } else {
//                 if (res.length() > 0) res.deleteCharAt(res.length() - 1);
//             }
//         }
//         return res.toString();
//     }
// }

class Solution {
    public String processStr(String s) {
        List<Character> res = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (ch != '*' && ch != '#' && ch != '%') {
                res.add(ch);
            } else if (ch == '#') {
                List<Character> copy = new ArrayList<>(res);
                res.addAll(copy);
            } else if (ch == '%') {
                Collections.reverse(res);
            } else { // ch == '*'
                if (!res.isEmpty()) {
                    res.remove(res.size() - 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : res) sb.append(c);
        return sb.toString();
    }
}
