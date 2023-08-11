/*
https://leetcode.com/problems/loud-and-rich/description/
*/

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = quiet.length;
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        int[] inDegree = new int[n];
        for(int[] edge : richer) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
            result[i] = i;
        }
        
        while(!queue.isEmpty()) {
            Integer curr = queue.poll();
            for(Integer neighbour : graph.get(curr)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
                
                if(quiet[result[neighbour]] > quiet[result[curr]]) {
                    result[neighbour] = result[curr];
                }
            }
        }
        return result;
    }
}

// TC: O(V + E), SC: O(V)