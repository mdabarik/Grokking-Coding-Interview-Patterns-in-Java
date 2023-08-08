/*
https://leetcode.com/problems/k-closest-points-to-origin/
Solve using heap
*/

class Solution {
    class Pair {
        int x, y;
        double distance;
        public Pair (int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    // Create a custom comparator to sort by distance in decreasing order
    Comparator<Pair> comparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Double.compare(p2.distance, p1.distance);
        }
    };

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(comparator);
        int i;
        for (i = 0; i < k; i++) {
            int x = points[i][0], y = points[i][1];
            double distance = Math.pow((x*x + y*y), 0.5);
            maxHeap.add(new Pair(x, y, distance));
        }
        while (i < points.length) {
            int x = points[i][0], y = points[i][1];
            double distance = Math.pow((x*x + y*y), 0.5);
            if (maxHeap.peek().distance > distance) {
                maxHeap.poll();
                maxHeap.add(new Pair(x, y, distance));
            }
            i++;
        }
        int[][] result = new int[maxHeap.size()][2];
        i = 0;
        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            result[i][0] = pair.x;
            result[i][1] = pair.y;
            i++;
        }
        return result;
    }
}