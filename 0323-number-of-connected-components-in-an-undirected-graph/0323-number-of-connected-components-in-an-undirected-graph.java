class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        int res = n;
        for (int[] edge : edges) {
            res -= union(par, rank, edge[0], edge[1]);
        }

        return res;
    }

    private int find(int[] par, int n1) {
        int res = n1;
        while (res != par[res]) {
            par[res] = par[par[res]]; // path compression
            res = par[res];
        }
        return res;
    }

    private int union(int[] par, int[] rank, int n1, int n2) {
        int p1 = find(par, n1);
        int p2 = find(par, n2);

        if (p1 == p2) {
            return 0;
        }

        if (rank[p2] > rank[p1]) {
            par[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            par[p2] = p1;
            rank[p1] += rank[p2];
        }

        return 1;
    }
}
