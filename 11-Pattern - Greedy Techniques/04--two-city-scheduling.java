/*
https://leetcode.com/problems/two-city-scheduling/description/
*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> ((a[0] - a[1]) - (b[0] - b[1])));
        int minCosts = 0;
        int left = 0, right = costs.length - 1;
        while (left < right) {
            minCosts += costs[left++][0] + costs[right--][1];
        }
        return minCosts;
    }
}
