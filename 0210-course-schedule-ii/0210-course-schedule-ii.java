class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph and fill indegrees
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        boolean[] visited = new boolean[numCourses];
        int[] result = new int[numCourses]; // To store the topological order
        int index = 0;

        // Add all nodes with indegree 0 to queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                visited[i] = true;
                result[index++] = i;
                count++;
            }
        }

        // BFS (Kahn's Algorithm)
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.offer(neighbor);
                        visited[neighbor] = true;
                        result[index++] = neighbor;
                        count++;
                    }
                }
            }
        }

        return count == numCourses ? result : new int[0];
    }
}
