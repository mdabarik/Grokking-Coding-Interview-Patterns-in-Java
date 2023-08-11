
/*
https://leetcode.com/problems/redundant-connection/
*/

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        int[] res = null;
        for(int[] edge: edges){
            if(!uf.union(edge[0]-1, edge[1]-1)){
                res = edge;
            }
        }
        return res;
    }
} 

class UnionFind{
    int[] rank;
    int[] root;
    
    public UnionFind(int n){
        root = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        if(root[x] != x){
            return root[x] = find(root[x]);
        }else{
            return root[x];
        }
    }
    
    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }else{
            return false;
        }
    }
}


/* ######### Educative ########### */

class UnionFind {

    public int[] parent;
    public int[] rank;

    // Constructor
    public UnionFind(int n) {
        
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // Function to find which subset a particular element belongs to
    // Returns FALSE if both vertices have the same parent, otherwise, updates the parent and rank lists by making a connection based on the passed edge
    // Returns TRUE if no cycle exits in the graph
    public int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    // Function to join two subsets into a single subset
    public boolean union(int v1, int v2) {
        
        // Find the root parents of v1 and v2
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) {
            return false;
        } 
        
        // Updates the parent and rank lists otherwise 
        else if (rank[p1] > rank[p2]) {

            parent[p2] = p1;
            rank[p1] += rank[p2];
        } 
        
        else {

            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
}


class RedundantConnections {
    
    public static int[] redundantConnection(int[][] edges) {

        UnionFind connections = new UnionFind(edges.length);

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (!connections.union(v1, v2)) {
                return edge;
            }
        }
        return new int[]{};
    }

    // Driver code
    public static void main(String[] args) {
        int[][][] edges = {
                {{1, 2}, {1, 3}, {2, 3}},
                {{1, 2}, {2, 3}, {1, 3}},
                {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}},
                {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {2, 4}},
                {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}}
        };

        for (int i = 0; i < edges.length; i++) {
            System.out.println((i + 1) + ".\tEdges: " + Arrays.deepToString(edges[i]));
            System.out.println("\n\tThe redundant connection in the graph is: " + Arrays.toString(redundantConnection(edges[i])));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }

}
