import java.util.*;

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // Step 1: Combine data and sort by timestamp
        int n = username.length;
        List<String[]> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(new String[]{username[i], String.valueOf(timestamp[i]), website[i]});
        }
        data.sort(Comparator.comparingInt(a -> Integer.parseInt(a[1])));

        // Step 2: Group websites visited by user
        Map<String, List<String>> userVisits = new HashMap<>();
        for (String[] entry : data) {
            userVisits.computeIfAbsent(entry[0], k -> new ArrayList<>()).add(entry[2]);
        }

        // Step 3: Generate all 3-sequence patterns and count unique users
        Map<String, Set<String>> patternUsers = new HashMap<>();
        for (String user : userVisits.keySet()) {
            List<String> visits = userVisits.get(user);
            Set<String> patterns = new HashSet<>();
            int len = visits.size();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        String pattern = visits.get(i) + "," + visits.get(j) + "," + visits.get(k);
                        patterns.add(pattern);
                    }
                }
            }
            for (String pattern : patterns) {
                patternUsers.computeIfAbsent(pattern, k -> new HashSet<>()).add(user);
            }
        }

        // Step 4: Find the most frequent pattern
        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Set<String>> entry : patternUsers.entrySet()) {
            String pattern = entry.getKey();
            int count = entry.getValue().size();
            if (count > maxCount || (count == maxCount && pattern.compareTo(result) < 0)) {
                result = pattern;
                maxCount = count;
            }
        }

        // Convert result to list
        return Arrays.asList(result.split(","));
    }
}
