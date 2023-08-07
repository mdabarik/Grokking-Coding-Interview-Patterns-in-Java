/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
*/

class Solution {
    class pair {
        int i, j, curr;
        public pair(int i, int j, int curr) {
            this.i = i;
            this.j = j;
            this.curr = curr;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<pair> minHeap = new PriorityQueue<>((a, b) -> a.curr - b.curr);
        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new pair(i, 0, matrix[i][0]));
        }
        int count = 0;
        while (!minHeap.isEmpty()) {
            pair tmp = minHeap.poll();
            count++;
            int i = tmp.i, j = tmp.j, sum = tmp.curr;
            if (j + 1 < matrix[0].length) {
                minHeap.add(new pair(i, j + 1, matrix[i][j + 1]));
            }
            if (count == k) return matrix[i][j];
        }
        return -1;
    }
}
// TC: O((n+k)logn), SC: O(n)