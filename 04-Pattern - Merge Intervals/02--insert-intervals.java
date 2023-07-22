/*
https://leetcode.com/problems/insert-interval/
*/

/* You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/ 


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;
        // find out interval on the left of newInterval (non-overlapping)
        while (i < n && intervals[i][1] < newInterval[0]) { 
            result.add(intervals[i]);
            i++;
        }
        // find this interval: [startTime, endTime]
        while (i < n && intervals[i][0] <= newInterval[1]) {
            int startTime = Math.min(intervals[i][0], newInterval[0]);
            int endTime = Math.max(intervals[i][1], newInterval[1]);
            newInterval[0] = startTime;
            newInterval[1] = endTime;
            i++;
        }
        result.add(newInterval);F
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }
} // TC: O(n), SC: O(1)

// intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]