/*
https://leetcode.com/problems/merge-intervals/
*/


/* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping. */

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (merged.getLast()[1] < currInterval[0]) {
                merged.add(currInterval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], currInterval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
} 
// TC: O(n log n + n) SC: O(1)
