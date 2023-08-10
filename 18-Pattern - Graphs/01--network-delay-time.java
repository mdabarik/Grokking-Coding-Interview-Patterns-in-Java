/*
https://leetcode.com/problems/network-delay-time/
*/

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            int source = edge[0], target = edge[1], weight = edge[2];
            graph.putIfAbsent(source, new ArrayList<>());
            graph.get(edge[0]).add(new int[]{target, weight});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new int[]{0, K});
        Set<Integer> visited = new HashSet<>();
        int max = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int src = curr[1], weight = curr[0];
            if (visited.contains(src)) continue;
            max = weight;
            visited.add(src);
            if (!graph.containsKey(src)) continue;
            for (int[] adj : graph.get(src)) {
                int tar = adj[0], tarW = adj[1];
                minHeap.add(new int[] {weight + tarW, tar});
            }
        }
        return visited.size() == N ? max : -1;
    }
}



import java.util.*;

class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjacency = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];
            adjacency.computeIfAbsent(source, key -> new ArrayList<>()).add(new int[]{destination, travelTime});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int delays = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];

            if (visited.contains(node))
                continue;

            visited.add(node);
            delays = Math.max(delays, time);
            List<int[]> neighbors = adjacency.getOrDefault(node, new ArrayList<>());

            for (int[] neighbor : neighbors) {
                int neighborNode = neighbor[0];
                int neighborTime = neighbor[1];
                if (!visited.contains(neighborNode)) {
                    int newTime = time + neighborTime;
                    pq.offer(new int[]{newTime, neighborNode});
                }
            }
        }

        if (visited.size() == n)
            return delays;

        return -1;
    }

    public static void main(String[] args) {
        int[][][] times = {
            { {2, 1, 1}, {3, 2, 1}, {3, 4, 2} },
            { {2, 1, 1}, {1, 3, 1}, {3, 4, 2}, {5, 4, 2} },
            { {1, 2, 1}, {2, 3, 1}, {3, 4, 1} },
            { {1, 2, 1}, {2, 3, 1}, {3, 5, 2} },
            { {1, 2, 2} }
        };

        int[] n = {4, 5, 4, 5, 2};
        int[] k = {3, 1, 1, 1, 2};

        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + ".\t times = " + Arrays.deepToString(times[i]));
            System.out.println("\t number of nodes 'n' = " + n[i]);
            System.out.println("\t starting node 'k' = " + k[i] + "\n");
            System.out.println("\t Minimum amount of time required = " + networkDelayTime(times[i], n[i], k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

// TC: O(E log V), SC: O(V + E)