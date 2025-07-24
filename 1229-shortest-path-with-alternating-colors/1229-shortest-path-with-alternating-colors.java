// class Solution {
//     public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
//         List[] adj=new ArrayList[n];
//         for(int i=0;i<n;i++){
//             adj[i]=new ArrayList<>();
//         }
//         for(int[] red:redEdges){// 0 for red
//             adj[red[0]].add(new int[]{red[1],0});
//         }
//         for(int[] blue:blueEdges){// 1 for blue
//             adj[blue[0]].add(new int[]{blue[1],0});
//         }
//         Queue<int[]> queue=new LinkedList<>();
//         int[] res=new int[n];
//         Arrays.fill(res,-1);
//         res[0]=0;
//         boolean[][] v=new boolean[n][2];//visited array,there are n nodes and each node can have 2 edges tp each, ie red and blue

//         queue.add(new int[]{0,0,-1});// current pos=0,distance=0 and the initially the color is also -1

//         //this while will find hthe dist between node 0 and rest of the nodes
//         //res[next[0]]=prev[1]+1; here we are updating that result array to store that particular result
//         while(queue.size()>0){
//             int[] prev=queue.remove();
//             List<int[]> nodes=adj[prev[0]];
//             for(int[] next:nodes){
//                 if(!v[next[0]][next[1]] && next[1]!=prev[2]){//node should not be visited and color should not be the same
//                     if(res[next[0]]==-1){
//                         res[next[0]]=prev[1]+1; 
//                     }
//                     v[next[0]][next[1]]=true;
//                     queue.add(new int[]{next[0], prev[1]+1, next[1]});
//                 }
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] red : redEdges) { // 0 for red
            adj[red[0]].add(new int[]{red[1],0});
        }
        for(int[] blue : blueEdges) { // 1 for blue
            adj[blue[0]].add(new int[]{blue[1],1});
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);
        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,-1}); // node, distance, prevColor
        visited[0][0] = true;
        visited[0][1] = true;
        res[0] = 0;

        while(!queue.isEmpty()) {
            int[] prev = queue.poll();
            int node = prev[0], dist = prev[1], prevColor = prev[2];

            for(int[] next : adj[node]) {
                int nextNode = next[0], edgeColor = next[1];
                if(!visited[nextNode][edgeColor] && edgeColor != prevColor) {
                    visited[nextNode][edgeColor] = true;
                    queue.add(new int[]{nextNode, dist+1, edgeColor});
                    if(res[nextNode] == -1) {
                        res[nextNode] = dist+1;
                    }
                }
            }
        }

        return res;
    }
}
