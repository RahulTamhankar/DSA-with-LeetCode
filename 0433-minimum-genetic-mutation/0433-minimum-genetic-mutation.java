import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                String current = queue.poll();
                if (current.equals(end)) return level;

                for (int i = 0; i < current.length(); i++) {
                    for (char c : new char[]{'A', 'C', 'G', 'T'}) {
                        if (c == current.charAt(i)) continue;
                        StringBuilder neighbor = new StringBuilder(current);
                        neighbor.setCharAt(i, c);
                        String next = neighbor.toString();

                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
