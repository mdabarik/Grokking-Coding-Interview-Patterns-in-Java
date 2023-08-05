/*
https://leetcode.com/problems/where-will-the-ball-fall/
*/

import java.util.*;

public class main {
    public static int[] findExitColumn(int[][] grid) {
        int[] result = new int[grid[0].length];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        for (int col = 0; col < grid[0].length; col++) {
            int currentColumn = col;

            for (int row = 0; row < grid.length; row++) {
                int nextColumn = currentColumn + grid[row][currentColumn];

                if (nextColumn < 0 || nextColumn > grid[0].length - 1 || grid[row][currentColumn] != grid[row][nextColumn]) {
                    break;
                }

                if (row == grid.length - 1) {
                    result[col] = nextColumn;
                }
                currentColumn = nextColumn;
            }
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        int[][][] grids = {
                {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}},
                {{1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1}, {-1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1}, {1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1}, {-1, -1, -1, 1, 1, -1, -1, -1, -1, 1, 1, -1}},
                {{-1, -1, -1, -1}, {1, 1, 1, 1}, {-1, -1, -1, -1}, {1, 1, 1, 1}},
                {{1}},
                {{-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}}
        };

        for (int i = 0; i < grids.length; i++) {
            System.out.println("Test Case #" + (i + 1) + "\n\nInput grid:");
            printMatrix(grids[i]);
            int[] output = findExitColumn(grids[i]);
            System.out.print("\nOutput: "+ Arrays.toString(output));
            System.out.println("\n" + new String(new char[100]).replace('\0', '-'));
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}

// TC: O(m * n), SC: O(1)clear
