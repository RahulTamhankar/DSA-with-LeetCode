import java.util.*;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        
        // Build adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                
                long dx = x2 - x1;
                long dy = y2 - y1;
                long distanceSq = dx * dx + dy * dy;
                
                if (r1 * r1 >= distanceSq) {
                    adj.get(i).add(j);
                }
            }
        }
        
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            dfs(i, adj, visited);
            result = Math.max(result, visited.size());
        }
        
        return result;
    }
    
    private void dfs(int u, List<List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(u)) return;
        
        visited.add(u);
        
        for (int v : adj.get(u)) {
            dfs(v, adj, visited);
        }
    }
}
