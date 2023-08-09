/*
https://leetcode.com/problems/flood-fill/description/
*/

class Solution {
    int[] DIRS = {0, 1, 0, -1, 0};
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image; // same color -> no need to replace
        m = image.length; n = image[0].length;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r == m || c < 0 || c == n || image[r][c] != oldColor) return;
        image[r][c] = newColor; // also mean we marked it as visited!
        for (int i = 0; i < 4; i++)
            dfs(image, r + DIRS[i], c + DIRS[i+1], oldColor, newColor);
    }
}



// full implementation
import java.util.*;

class FloodFill {

    public static void dfs(int[][] grid, int row, int col, int oldTarget, int newTarget) {
        int[][] adjacentCells = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        int gridLength = grid.length;
        int totalCells = grid[0].length;

        for (int[] cellValue : adjacentCells) {
            int i = row + cellValue[0];
            int j = col + cellValue[1];

            if (i < gridLength && i >= 0 && j < totalCells && j >= 0 && grid[i][j] == oldTarget) {
                grid[i][j] = newTarget;
                dfs(grid, i, j, oldTarget, newTarget);
            }
        }
    }

    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
        if (grid[sr][sc] == target) {
            return grid;
        } else {
            int oldTarget = grid[sr][sc];
            grid[sr][sc] = target;
            dfs(grid, sr, sc, oldTarget, target);

            return grid;
        }
    }


    // Driver code
    public static void main(String[] args){
        int[][][] grids = {
                {{1, 1, 0, 1, 0}, 
                {0, 0, 0, 0, 1}, 
                {0, 0, 0, 1, 1}, 
                {1, 1, 1, 1, 0}, 
                {1, 0, 0, 0, 0}},

                {{1, 1, 0, 1}, 
                {0, 0, 0, 0}, 
                {0, 0, 0, 1}, 
                {1, 1, 1, 1}},

                {{9, 9, 6, 9}, 
                {6, 9, 9, 6}, 
                {6, 9, 9, 9}, 
                {9, 9, 9, 9}},

                {{1, 1, 0, 1}, 
                {0, 1, 0, 0}, 
                {0, 1, 1, 0}, 
                {1, 0, 1, 1}},
        
                {{1, 2, 0, 0}, 
                {3, 1, 3, 6}, 
                {7, 2, 1, 5}, 
                {1, 9, 2, 1}}
        };

        int[] sr = {4, 2, 2, 2, 1};
        int[] sc = {3, 3, 1, 3, 1};
        int[] target = {3, 2, 1, 0, 4};

        for (int i = 0; i < grids.length; i++) {
            System.out.println((i + 1) + ".\t Grid before flood fill: " + Arrays.deepToString(grids[i]));
            System.out.println("\t Starting row and column are: (" + sr[i] + ", " + sc[i] + ")");
            System.out.println("\t Target value: " + target[i]);
            
            int[][] result = floodFill(grids[i], sr[i], sc[i], target[i]);
            System.out.println("\t After perform flood fill: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}