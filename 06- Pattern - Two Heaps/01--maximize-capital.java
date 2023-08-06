/*
https://leetcode.com/problems/ipo/
*/

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length, currCapital = w;
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            capitalMinHeap.add(new int[] {capital[i], i});
        }
        PriorityQueue<int[]> profitMaxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int i = 0;
        while (i < k) {
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currCapital) {
                int[] tmp = capitalMinHeap.poll();
                profitMaxHeap.add(new int[] {profits[tmp[1]], tmp[1]});
            }
            if (profitMaxHeap.isEmpty()) break;
            int x = profitMaxHeap.poll()[0];
            currCapital += x;
            i++;
        }
        return currCapital;
    }
}

// TC: o(n log n) SC: O(n)

class MaximizeCapital {
	public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        int n = capitals.length;
		int currentCapital = c;
        PriorityQueue<int[]> CapitalminHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; ++i) {
            CapitalminHeap.offer(new int[] {capitals[i], i});
        }
        PriorityQueue<int[]> ProfitsmaxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		int i = 0;
        while (i < k) {
            while (!CapitalminHeap.isEmpty() && CapitalminHeap.peek()[0] <= currentCapital) {
				int[] j = CapitalminHeap.poll();
                ProfitsmaxHeap.offer(new int[]{profits[j[1]], j[1]});
            }
            if (ProfitsmaxHeap.isEmpty()) {
                break;
            }
			int x = ProfitsmaxHeap.poll()[0];
            currentCapital += x;
			i++;
        }
        return currentCapital;
    }

	public static void main(String[] args) {
		int[] c = { 0, 1, 2, 1, 7, 2 };
		int[] k = { 1, 2, 3, 3, 2, 4 };
		int[][] capitals = {
			{1, 1, 2},
			{1, 2, 2, 3}, 
      		{1, 3, 4, 5, 6}, 
      		{1, 2, 3, 4}, 
      		{6, 7, 8, 10}, 
      		{2, 3, 5, 6, 8, 12}
		};
		int[][] profits = {
			{1, 2, 3},
			{2, 4, 6, 8}, 
        	{1, 2, 3, 4, 5}, 
        	{1, 3, 5, 7}, 
        	{4, 8, 12, 14}, 
        	{1, 2, 5, 6, 8, 9}
		};
		for (int i = 0; i<k.length; i++) {
			System.out.println((i + 1) + ".\tProject capital requirements: " + Arrays.toString(capitals[i]));
			System.out.println("\tProject expected profits: " + Arrays.toString(profits[i]));
			System.out.println("\tNumber of projects: " + k[i]);
			System.out.println("\tStart-up capital: " + c[i]);
			System.out.println("\n\tMaximum Capital earned: " + maximumCapital(c[i], k[i], capitals[i], profits[i]));
		}
	}
}

/*
To recap, the solution to this problem can be divided into the following four steps:
1. Push all capitals values in a min-heap.
2. Select projects that can be invested in the range of the current capital and push their profits in a max-heap.
3. Select the project from the max-heap that yields the maximum profit.
4. Add the profit from the selected project to the current capital.
Repeat steps 2 - 4 until k projects have been selected.
*/