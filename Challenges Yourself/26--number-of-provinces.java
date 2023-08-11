/*
https://leetcode.com/problems/number-of-provinces/editorial/
*/

class Solution {
    private int[] vis;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i != j){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        vis = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                dfs(i, graph);
                count++;
            } 
        }
        return count;
    }
    private void dfs(int node, ArrayList<Integer>[] graph){
        vis[node] = 1;
        for(int neighbor : graph[node]){
            if(vis[neighbor] == 0){
                dfs(neighbor, graph);
            }
        }
    }
}


class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union_set(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind dsu = new UnionFind(n);
        int numberOfComponents = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && dsu.find(i) != dsu.find(j)) {
                    numberOfComponents--;
                    dsu.union_set(i, j);
                }
            }
        }

        return numberOfComponents;
    }
}