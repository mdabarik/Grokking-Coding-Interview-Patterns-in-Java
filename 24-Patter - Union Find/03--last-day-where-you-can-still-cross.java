/*
https://leetcode.com/problems/last-day-where-you-can-still-cross/
*/


// Binary Search + BFS
class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});
                grid[0][i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            if (r == row - 1) {
                return true;
            }
            
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = -1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        return false;
    }
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = row * col;
        
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}


// Disjoint Set (DSU)

class LastDayToCross {

    public static int lastDayToCross(int rows, int cols, int[][] waterCells) {

        int day = 0;
        int[][] matrix = new int[rows][cols];
        int leftNode = 0;
        int rightNode = rows * cols + 1;

        int[][] waterDirections = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int[][] convertedWaterCells = new int[waterCells.length][2];

        for (int i = 0; i < waterCells.length; i++) {
            convertedWaterCells[i] = new int[]{waterCells[i][0] - 1, waterCells[i][1] - 1};
        }
        
        UnionFind uf = new UnionFind(rows * cols + 2);
        
        for (int[] cell : convertedWaterCells) {
            int row = cell[0];
            int col = cell[1];

            matrix[row][col] = 1;

            for (int[] direction : waterDirections) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (withinBounds(newRow, newCol, rows, cols) && matrix[newRow][newCol] == 1) {
                    uf.union(findIndex(row, col, cols), findIndex(newRow, newCol, cols));
                }
            }

            if (col == 0) {
                uf.union(findIndex(row, col, cols), leftNode);
            }
            if (col == cols - 1) {
                uf.union(findIndex(row, col, cols), rightNode);
            }
            if (uf.find(leftNode) == uf.find(rightNode)) {
                break;
            }
            day++;
        }
        return day;
    }

    // helper functions

    // maps the index of the element in 2-D matrix to an index of the 1-D array (reps)
    public static int findIndex(int currentRow, int currentCol, int cols) {
        return currentRow * cols + (currentCol + 1);
    }

    // checks whether the water cells to be connected are within the bounds of the matrix as per given dimensions
    public static boolean withinBounds(int row, int col, int rows, int cols) {
        return col >= 0 && col < cols && row >= 0 && row < rows;
    }

    // driver code
    public static void main(String[] args) {
        int[][][] allWaterCells = {
            {{1, 2}, {2, 1}, {3, 3}, {2, 2}, {1, 1}, {1, 3}, {2, 3}, {3, 2}, {3, 1}},
            {{1, 1}, {2, 1}, {1, 2}, {2, 2}},
            {{1, 1}, {1, 2}, {1, 3}, {2, 1}, {3, 1}, {2, 2}, {3, 2}, {2, 3}, {3, 3}},
            {{1, 5}, {2, 5}, {2, 4}, {2, 3}, {2, 2}, {3, 2}, {4, 2}, {4, 1}, {3, 1}, {2, 1},
             {1, 1}, {1, 2}, {1, 3}, {1, 4}, {3, 3}, {3, 5}, {3, 4}, {4, 5}, {4, 3}, {4, 4}},
            {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {2, 5}, {2, 6}, {2, 7}, {3, 1},
             {3, 2}, {3, 3}, {3, 7}, {4, 7}, {4, 5}, {4, 4}, {4, 3}, {4, 2}, {4, 1}, {5, 1}, {5, 2}, {5, 3}, {5, 4},
             {5, 5}, {5, 7}, {6, 7}, {7, 7}, {7, 6}, {7, 5}, {7, 4}, {7, 3}, {7, 2}, {7, 1}, {6, 1}, {6, 2}, {6, 3},
             {6, 4}, {6, 5}, {6, 6}, {5, 6}, {4, 6}, {3, 6}, {3, 5}, {3, 4}, {2, 4}, {2, 3}, {2, 2}, {2, 1}, {1, 1}},
            {{3, 2}, {1, 1}, {1, 2}, {3, 3}, {2, 3}, {1, 3}, {2, 1}, {2, 2}, {3, 1}}
        };

        int[] allRows = {3, 2, 3, 4, 7, 3};
        int[] allCols = {3, 2, 3, 5, 7, 3};

        for (int i = 0; i < allWaterCells.length; i++) {
            System.out.println(i + 1 + ". \tNumber of rows: " + allRows[i]);
            System.out.println("\tNumber of columns: " + allCols[i]);
            System.out.println("\n\tCells to be flooded: "+ Arrays.deepToString(allWaterCells[i]));
            int lastDay = lastDayToCross(allRows[i], allCols[i], allWaterCells[i]);

            System.out.println("\n\tLast day where you can still cross: " + lastDay);
            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}



class DSU {
    int[] root, size;
    
    public DSU(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);
    }
    
    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        
        if (size[rootX] > size[rootY]) {
            int tmp = rootX;
            rootX = rootY;
            rootY = tmp;
        }
        root[rootX] = rootY;
        size[rootY] += size[rootX];
    }
}

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        DSU dsu = new DSU(row * col + 2);
        int[][] grid = new int[row][col];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int i = cells.length - 1; i >= 0; i--) {
            int r = cells[i][0] - 1, c = cells[i][1] - 1;
            grid[r][c] = 1;
            int index1 = r * col + c + 1;
            for (int[] d : directions) {
                int newR = r + d[0], newC = c + d[1];
                int index2 = newR * col + newC + 1;
                if (newR >= 0 && newR < row && newC >= 0 && newC < col && grid[newR][newC] == 1) {
                    dsu.union(index1, index2);
                }
            }
            if (r == 0) {
                dsu.union(0, index1);
            }
            if (r == row - 1) {
                dsu.union(row * col + 1, index1);
            }
            if (dsu.find(0) == dsu.find(row * col + 1)) {
                return i;
            }
        }
        return -1;
    }
}