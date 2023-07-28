/*
https://leetcode.com/problems/rotting-oranges/
https://practice.geeksforgeeks.org/batch/test-series-bundle/track/amazon-graphs/problem/rotten-oranges2536
*/


class Solution {
    class pair {
        int r, c;
        public pair (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<pair> queue = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new pair(r, c));
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // top, bottom, left, right
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                pair p = queue.poll();
                int row = p.r;
                int col = p.c;
                for (int[] d : dir) {
                    int x = row + d[0];
                    int y = col + d[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0) continue;
                    grid[x][y] = 2;
                    queue.add(new pair(x, y));
                    fresh -= 1;
                }
            }
        }
        if (fresh != 0) return -1;
        return level - 1; // for last rotten orrange on queue
    }
}