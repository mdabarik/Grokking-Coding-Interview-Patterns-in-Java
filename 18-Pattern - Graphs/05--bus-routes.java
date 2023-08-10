/*
https://leetcode.com/problems/bus-routes/
*/

class Solution {
    class Pair {
        int source, busTaken;
        public Pair (int source, int busTaken) {
            this.source = source;
            this.busTaken = busTaken;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                if (!adjList.containsKey(station)) {
                    adjList.put(station, new ArrayList<>());
                }
                adjList.get(station).add(i);
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source, 0));
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int station = pair.source, busTaken = pair.busTaken;
            if (station == target) return busTaken;
            if (!adjList.containsKey(station)) continue;
            for (int bus : adjList.get(station)) {
                if (visited.contains(bus)) continue;
                for (int s : routes[bus]) {
                    queue.add(new Pair(s, busTaken + 1));
                }
                visited.add(bus);
            }
        }
        return -1;
    }
}

// TC: O(R*S), R=route, S=stations
// SC: O(R*S)