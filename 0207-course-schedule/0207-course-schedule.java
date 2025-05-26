class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        // Add all nodes with indegree 0 to queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                visited[i] = true;
                count++;
            }
        }

        // BFS (Kahn's Algorithm)
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {//If a neighbor has no remaining prerequisites
                        q.offer(neighbor);
                        visited[neighbor] = true; //Mark the course as processed (taken).Avoid revisiting and double-counting.

                        count++;
                    }
                }
            }
        }

        return count == numCourses;
    }
}


//prerequisites = { {1, 0}, {2, 1} }; 
// adj.get(pre[1]).add(pre[0]) ???
// becomes:

// adj.get(0).add(1); → course 0 points to 1
// adj.get(1).add(2); → course 1 points to 2

// Resulting adj list:
// adj = [
//   [1],  // course 0 unlocks 1
//   [2],  // course 1 unlocks 2
//   []    // course 2 unlocks nothing
// ];


// Let's say:
// numCourses = 4;
// prerequisites = [[1, 0], [2, 1], [3, 2]];
// This means:
// To take course 1, you must finish course 0
// To take course 2, you must finish course 1
// To take course 3, you must finish course 2
// So the graph is: 0 → 1 → 2 → 3

//  Initial Setup:
// indegree = [0,1,1,1] → because:

// 0 has no prereqs

// 1 depends on 0

// 2 depends on 1

// 3 depends on 2

// adj = [[1], [2], [3], []]

// q = [0] → only course 0 has indegree 0

// visited = [true, false, false, false]

// count = 1 → one course can be taken without prerequisites

// \U0001f9e0 Iteration 1:
// node = 0, adj[0] = [1]

// indegree[1]-- → indegree[1] = 0

// q.add(1) → visited[1] = true, count = 2

// \U0001f9e0 Iteration 2:
// node = 1, adj[1] = [2]

// indegree[2]-- → indegree[2] = 0

// q.add(2) → visited[2] = true, count = 3

// \U0001f9e0 Iteration 3:
// node = 2, adj[2] = [3]

// indegree[3]-- → indegree[3] = 0

// q.add(3) → visited[3] = true, count = 4

// \U0001f9e0 Iteration 4:
// node = 3, adj[3] = []

// Nothing to do

// ✅ End:
// All nodes processed

// count == numCourses (4) → return true

// \U0001f4ca Final Visualization:
// less
// Copy
// Edit
// [0] → [1] → [2] → [3]
//  ^     ^     ^     ^
//  |     |     |     |
// start  q1    q2    q3
// Each level unlocks the next by reducing indegree to 0.

// \U0001f4cc Summary:
// We perform level-order traversal of the graph

// Only add nodes to the queue when their indegree becomes 0

// If we can process all nodes, there's no cycle → return true

// Otherwise (cycle), count < numCourses → return false

//////////////////////
//Kahn
// | Line               | Intuition                                     |
// | ------------------ | --------------------------------------------- |
// | `q.poll()`         | Take a course with no remaining prerequisites |
// | `adj.get(node)`    | Find all courses that depend on it            |
// | `indegree--`       | Mark one prerequisite as completed            |
// | `if indegree == 0` | If all prereqs are done, unlock the course    |
// | `q.offer()`        | Add unlocked course to the queue              |
// | `visited[]`        | Don’t reprocess the same course               |
// | `count++`          | Track how many courses we’ve completed        |


////////EXAMPLE 2
// Absolutely! Let's walk through a concrete example where the condition if (indegree[neighbor] == 0) is false, meaning a course still has remaining prerequisites, so it shouldn't be added to the queue yet.

// \U0001f4da Example:
// Input:
// java
// Copy
// Edit
// numCourses = 4
// prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2]]
// \U0001f501 Interpretation:
// To take course 1 → you need course 0

// To take course 2 → you need course 0

// To take course 3 → you need courses 1 and 2

// This forms the graph:

// markdown
// Copy
// Edit
// 0 → 1 → 
//    ↘   ↘
//      2   → 3
// \U0001f4ca Initial indegree array:
// cpp
// Copy
// Edit
// indegree[0] = 0
// indegree[1] = 1  // because of [1, 0]
// indegree[2] = 1  // because of [2, 0]
// indegree[3] = 2  // because of [3, 1] and [3, 2]
// \U0001f9e0 Initial state:
// Queue starts with 0 (because indegree[0] == 0)

// visited[0] = true, count = 1

// \U0001f4a1 Processing course 0:
// Neighbors of 0: [1, 2]

// First: neighbor = 1
// indegree[1]-- → now 0

// ✅ indegree == 0 is true, so we enqueue 1

// Second: neighbor = 2
// indegree[2]-- → now 0

// ✅ indegree == 0 is true, so we enqueue 2

// \U0001f4a1 Next: process course 1
// Neighbors of 1: [3]

// indegree[3]-- → now 1

// For neighbor = 3
// ❌ indegree == 0 is false, so we do not enqueue it yet
// → because course 2 still needs to be taken before 3 is eligible

// \U0001f4a1 Next: process course 2
// Neighbors of 2: [3]

// indegree[3]-- → now 0

// Now:

// ✅ indegree == 0 is true, so we enqueue 3

// ✅ Final state:
// We visited all 4 courses → count == numCourses

// \U0001f3af Point:
// In the step after visiting course 1, indegree[3] was 1, so:

// java
// Copy
// Edit
// if (indegree[neighbor] == 0) // was false for neighbor = 3
// This correctly prevented us from adding course 3 to the queue too early, preserving correct topological order.

